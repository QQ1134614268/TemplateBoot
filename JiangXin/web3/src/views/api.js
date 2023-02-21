import {getJson3} from "@/api/http";

export const getContent = "/api/img/getInfo";
export const updateTree = "/api/img/updateTree";
export const img_getPage = "/api/img/getPage";
export const imgAdd = "/api/img/create";
export const ImgType_getPage = "/api/ImgTypeController/getPage"


export const HomeDoor = '/HomeDoor';
export const Home = '/Home';
export const MessageBoard = '/MessageBoard';
export const Info = '/Info';
export const DecorationPlan = '/DecorationPlan';
export const root = '/';

export const admin = '/admin';
export const ImgAdmin = '/admin/img';
export const AdminHome = '/admin/home';
export const AdminMessageBoard = '/admin/MessageBoard';
export const adminLogin = '/admin/login';
export const adminSave = '/admin/save';


export const ImgType = '/Admin/ImgType';

export async function getAllTree2(data) {
    let ret = await getJson3(getContent, data)
    return ret.data;
}