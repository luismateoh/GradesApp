export { errorHandler };

function errorHandler(err, res) {
    if (typeof (err) === 'string') {

        return res.status(400).json({ message: err });
    }

    if (err.name === 'UnauthorizedError') {
        // jwt authentication error
        return res.status(401).json({ message: 'Invalid Token - Unauthorized' });
    }

    if (err.name === 'ForbiddenError') {
        // ForbiddenError
        return res.status(403).json({ message: 'Access to the requested resource is forbidden' });
    }


    // default to 500 server error
    return res.status(500).json({ message: err.message });
}