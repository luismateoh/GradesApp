import getConfig from 'next/config';

import { fetchWrapper } from '../helpers';

const { publicRuntimeConfig } = getConfig();
const BaseUrl = `${publicRuntimeConfig.apiUrl}/periods`;

export const periodService = {
    getPeriods,
    getPeriodsbyYear,
    createPeriod,
};

function getPeriods() {
    return fetchWrapper.get(BaseUrl);
}
 function getPeriodsbyYear(year) {
    return fetchWrapper.get(`${BaseUrl}?year=${year}`);
}
function createPeriod(period) {
    return fetchWrapper.post(BaseUrl, period);
}


