import CryptoJS from "crypto-js";
import {SALT_WORK_FACTOR, TOKEN} from "./config";
import jwt_decode from "jwt-decode";

export function beforeImgUpload() {
}


export function get_salt_pwd(pwd) {
    // todo 密码明文
    let keyHex = CryptoJS.enc.Utf8.parse(SALT_WORK_FACTOR);
    let encrypted = CryptoJS.DES.encrypt(pwd, keyHex, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });
    return encrypted.toString();

    // console.log(window.btoa('china is so nb'))
    // // 编码
    // "Y2hpbmEgaXMgc28gbmI="
    // window.atob("Y2hpbmEgaXMgc28gbmI=") // 解码
    // "china is so nb"
}

export function detectOS() {
    let sUserAgent = navigator.userAgent;
    let isWin = (navigator.platform === "Win32") || (navigator.platform == "Windows");
    let isMac = (navigator.platform === "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
    if (isMac) return "Mac";
    let isUnix = (navigator.platform === "X11") && !isWin && !isMac;
    if (isUnix) return "Unix";
    let isLinux = (String(navigator.platform).indexOf("Linux") > -1);
    if (isLinux) return "Linux";
    if (isWin) {
        let isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1;
        if (isWin2K) return "Win2000";
        let isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1;
        if (isWinXP) return "WinXP";
        let isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1;
        if (isWin2003) return "Win2003";
        let isWinVista = sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1;
        if (isWinVista) return "WinVista";
        let isWin7 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1;
        if (isWin7) return "Win7";
    }
    return "other";
}

export function isApp() {
    if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
        //alert(navigator.userAgent);
        alert('这是IOS');
    } else if (/(Android)/i.test(navigator.userAgent)) {
        //alert(navigator.userAgent);
        alert('这是Android');
    } else {
        alert('这是PC');
    }
}

export function fmtDateY_M_D(date) {
    let char = '-';
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();

    if (month >= 1 && month <= 9) {
        month = '0' + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = '0' + strDate;
    }
    return year + char + month + char + strDate;
}

export function fmtDateY_M_D_H_M_S(date) {
    let char = '-';
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();

    if (month >= 1 && month <= 9) {
        month = '0' + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = '0' + strDate;
    }
    return year + char + month + char + strDate + " " + hours + ":" + minutes + ":" + seconds;
}

export function getDateY_M_D() {
    let date = new Date();
    return fmtDateY_M_D(date);
}

export function toTree(arr) {
    let ret = [];
    let tree = {};
    for (let i = 0; i < arr.length; i++) {
        let obj = arr[i];
        if (obj.label === undefined) {
            obj.label = 'other';
        }
        if (tree[obj.label] !== undefined) {
            tree[obj.label].push(obj);
        } else {
            tree[obj.label] = [obj];
            ret.push({
                label: obj.label,
                data: tree[obj.label]
            });
        }
    }

    return ret;
}

export function getUserInfoByToken() {
    let token = localStorage.getItem(TOKEN);
    console.log(token);
    if (token) {
        try {
            return jwt_decode(token);
        } catch (ex) {
            console.log('捕获到异常：', ex);
        }
    }
    return null;
}

export function getUserIdByToken() {
    let user = getUserInfoByToken();
    if (user === undefined) {
        return user;
    }
    return getUserInfoByToken().id;
}
