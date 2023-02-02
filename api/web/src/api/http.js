import service from "./req";

export const getJson3 = (url, params) => {
    return service({
        method: 'get', url: url, params: params
    });
};
export const postJson3 = (url, data) => {
    return service({
        method: 'POST', url: url, data: data
    });
};
export const postForm3 = (url, data = {}) => {
    return service({
        method: 'POST', url: url, data: data, headers: {
            'Content-Type': 'multipart/form-data;'
        }
    });
};
