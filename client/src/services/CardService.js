import axios from 'axios';

export default {
    list() {
        return axios.get('/cards');
    },
    get(id) {
        return axios.get(`/cards/${id}`);
    },
    add(card) {
        return axios.post('/cards', card);
    },
    delete(id) {
        return axios.delete(`/cards/${id}`);
    }
}