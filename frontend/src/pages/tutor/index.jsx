import React, {useEffect, useState} from "react";
import Layout from "../../components/layout";
import {userService} from "../../services";

export default function TutorIndex() {
    const [user, setUser] = useState(userService.userValue);
    useEffect(() => {
        userService.getUserInfo().then(x => setUser(x));

    }, []);
    return (
        <>
            <Layout>
                <>
                    <h1>Admin Index</h1>
                    {user &&
                        <ul>
                            <li>names = {user.names} </li>
                            <li>lastNames = {user.lastNames}</li>
                            <li>email = {user.email}</li>
                            <li>phone = {user.phone}</li>
                            <li>address = {user.address}</li>
                            <li>password = {user.password}</li>
                        </ul>
                    }
                    {!user && <div>cargando...</div>}
                </>
            </Layout>

        </>
    );
}
TutorIndex.layout = Layout;

