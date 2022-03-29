import getConfig from 'next/config';
const expressJwt = require('express-jwt');
const util = require('util');

const { serverRuntimeConfig } = getConfig();

export { jwtMiddleware };

function jwtMiddleware(req, res) {
    const middleware = expressJwt({ secret: serverRuntimeConfig.secret, algorithms: ['HS256'] }).unless({
        path: [
            // public routes that don't require authentication
            '/api/users/authenticate',
            '/api/users/register',
            '/api/users/forgot-password',
            '/',
            '/login',
        ]
    });

    return util.promisify(middleware)(req, res);
}