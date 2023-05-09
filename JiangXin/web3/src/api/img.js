import {getJson3} from "@/api/http";
import {getContent} from "@/api/api";


export async function getAllTree2(data) {
    let ret = await getJson3(getContent, data)
    return ret.data;
}
