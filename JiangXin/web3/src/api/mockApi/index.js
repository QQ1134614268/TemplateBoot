// import {getAllTree, getContent} from "@/views/api";
//
// const Mock = require('mockjs')
// Mock.mock('/api/user/login', {
//     code: 1,
//     data: "token.token.token"
// });
// Mock.mock('/api/img', {
//     code: 1,
//     data: "1122"
// });
//
// Mock.mock(getAllTree, {
//     code: 1,
//     data: [
//         {type: "中式", content: [{id: 1, name: "中式1"}, {id: 2, name: "中式2"}, {id: 3, name: "中式3"},]},
//         {type: "日式", content: [{id: 1, name: "日式1"}, {id: 2, name: "日式2"}, {id: 3, name: "日式3"},]},
//         {type: "欧式", content: [{id: 1, name: "欧式1"}, {id: 2, name: "欧式2"}, {id: 3, name: "欧式3"},]},
//         {type: "最火", content: [{id: 1, name: "中式1"}, {id: 4, name: "日式1"}, {id: 7, name: "欧式1"},]},
//         {type: "曾看过", content: [{id: 1, name: "中式1"}]},
//     ]
// });
// Mock.mock(RegExp(getContent+"*"), {
//     code: 1,
//     data: {
//         id: 1,
//         img: "/xx/xx",
//         name: "中式1",
//         description: "中式1-最酷炫的风",
//         parentId: 0,
//         children: [
//             {id: 2, img: "/xx/xx", name: "中式1", description: "中式1-最酷炫的风", parentId: 1},
//             {id: 3, img: "/xx/xx", name: "中式1", description: "中式1-最酷炫的风", parentId: 1},
//             {id: 4, img: "/xx/xx", name: "中式1", description: "中式1-最酷炫的风", parentId: 1},
//         ]
//     },
// });
