import axios from 'axios';

export default {
    list() {
        return axios.get('/store');
    },
    get(storeItemId) {
        return axios.get(`/store/${storeItemId}`);
    },
    getMyListings() {
        return axios.get('/store/mycards');
    },
    putCardUpForSale(storeItem) {
        return axios.post('/store', storeItem);
    },
    takeDownStoreItem(storeItemId) {
        return axios.delete(`/store/${storeItemId}`);
    }
}