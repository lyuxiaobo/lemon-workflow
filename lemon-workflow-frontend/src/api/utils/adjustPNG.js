export const adjustPNG = (base64PNG) => {
    let img = new Image();//创建图片对象
    img.src = 'data:image/png;base64,' + base64PNG;
    var result = null;
    let c = document.createElement('canvas');//创建处理画布对象
    let ctx = c.getContext('2d');
    c.width = img.width;
    c.height = img.height;
    ctx.drawImage(img, 0, 0);//绘制
    let imgData = ctx.getImageData(0, 0, c.width, c.height).data;//读取图片数据
    let lOffset = c.width, rOffset = 0, tOffset = c.height, bOffset = 0;
    for (let i = 0; i < c.width; i++) {
        for (let j = 0; j < c.height; j++) {
            let pos = (i + c.width * j) * 4
            if (imgData[pos] === 255 || imgData[pos + 1] === 255 || imgData[pos + 2] === 255 || imgData[pos + 3] === 255) {
                bOffset = Math.max(j, bOffset); // 找到有色彩的最下端
                rOffset = Math.max(i, rOffset); // 找到有色彩的最右端
                tOffset = Math.min(j, tOffset); // 找到有色彩的最上端
                lOffset = Math.min(i, lOffset); // 找到有色彩的最左端
            }
        }
    }
    lOffset++;
    rOffset++;
    tOffset++;
    bOffset++;
    let x = document.createElement("canvas");//创建处理后画布对象
    x.width = rOffset - lOffset;
    x.height = bOffset - tOffset;
    let xx = x.getContext("2d");
    xx.drawImage(img, lOffset, tOffset, x.width, x.height, 0, 0, x.width, x.height);//绘制
    result = x.toDataURL();//得到最终裁剪出来的base64
    img.src = result;
    return result;
}