import getConfig from 'next/config';

import { fetchWrapper } from '../helpers';

const { publicRuntimeConfig } = getConfig();
const BaseUrl = `${publicRuntimeConfig.apiUrl}/institutions`;

export const institutionService = {
    updateInstitution,
    getInstitution
};

function updateInstitution(institution) {
    return fetchWrapper.put(`${BaseUrl}/${institution.id}`, institution);
}

function getInstitution(id) {
    return fetchWrapper.get(BaseUrl+'/'+id);
}

