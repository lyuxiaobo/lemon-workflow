export const fileSizeTranslator = (file_size_byte) => {
    let size = "";
    if( file_size_byte < 1024 ){
        //如果小于0.1KB转化成B
        size = file_size_byte.toFixed(2) + "B";
    }else if(file_size_byte < 0.1 * 1024 * 1024 ){
        //如果小于0.1MB转化成KB
        size = (file_size_byte / 1024).toFixed(2) + "KB";
    }else if(file_size_byte < 0.1 * 1024 * 1024 * 1024){
        //如果小于0.1GB转化成MB
        size = (file_size_byte / (1024 * 1024)).toFixed(2) + "MB";
    }else{
        //其他转化成GB
        size = (file_size_byte / (1024 * 1024 * 1024)).toFixed(2) + "GB";
    }

    let sizeStr = size + "";
    let len = sizeStr.indexOf("\.");
    let dec = sizeStr.substr(len + 1, 2);
    if(dec === "00"){
        //当小数点后为00时 去掉小数部分
        return sizeStr.substring(0,len) + sizeStr.substr(len + 3,2);
    }
    return sizeStr;
}