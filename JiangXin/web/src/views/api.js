import {getJson3} from "@/api/http";

export const getContent = "/api/img/getInfo";
export const getAllTree = "/api/img/getTreeAll";
export const updateTree = "/api/img/updateTree";
export const getPage = "/api/img/getPage";
export const imgAdd = "/api/img/create";


export const Home = '/Home';
export const MessageBoard = '/MessageBoard';
export const Info = '/Info';
export const DecorationPlan = '/DecorationPlan';
export const Admin = '/Admin';
export const save = '/save';
export const root = '/';

export const ImgType = '/Admin/ImgType';

export async function getAllTree2(data) {
    let ret = await getJson3(getPage, data)
    return ret.data.data.records;
}