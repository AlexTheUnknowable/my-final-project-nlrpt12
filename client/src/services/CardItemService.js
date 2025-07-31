import axios from 'axios';

export default {
    list() {
        return axios.get(`/cards/mycards`);
    },
    getByCardItemId(id) {
        return axios.get(`/carditem/${id}`);
    }
}