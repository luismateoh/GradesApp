import getConfig from 'next/config';

import { fetchWrapper } from '../helpers';

const { publicRuntimeConfig } = getConfig();
const BaseUrl = `${publicRuntimeConfig.apiUrl}/subjects`;

export const subjectService = {
    postSubject,
};

function postSubject(subject) {
    return fetchWrapper.post(BaseUrl, subject);
}



