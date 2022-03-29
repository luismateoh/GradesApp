import { BehaviorSubject } from 'rxjs';
import getConfig from 'next/config';
import Router from 'next/router'

import { fetchWrapper } from '../helpers';

const { publicRuntimeConfig } = getConfig();
const authBaseUrl = `${publicRuntimeConfig.apiUrl}/auth`;
const userBaseUrl = `${publicRuntimeConfig.apiUrl}/users`;
const userSubject = new BehaviorSubject(process.browser && JSON.parse(localStorage.getItem('user')));

export const userService = {
    user: userSubject.asObservable(),
    get userValue () { return userSubject.value },
    login,
    logout,
    getUserInfo,
    getAll,
    getStudents,
    getTutors,
};

function login(username, password) {
    return fetchWrapper.post(`${authBaseUrl}/authenticate`, { username, password })
        .then(response => {
            console.log(response);
            const { id, names, role } = response;
            const authdata = window.btoa(username + ':' + password);
            const user = { id, names, role, authdata };
            // publish user to subscribers and store in local storage to stay logged in between page refreshes
            userSubject.next(user);
            localStorage.setItem('user', JSON.stringify(user));

            return user;
        });
}

function logout() {
    // remove user from local storage, publish null to user subscribers and redirect to login page
    localStorage.removeItem('user');
    userSubject.next(null);
    Router.push('/login');
}

function getAll() {
    return fetchWrapper.get(authBaseUrl);
}

function getUserInfo() {
    return fetchWrapper.get(userBaseUrl+'/me');

}
function getStudents() {
    return fetchWrapper.get(userBaseUrl+'/by?role=STUDENT');
}
function getTutors() {
    return fetchWrapper.get(userBaseUrl+'/by?role=TUTOR');
}
