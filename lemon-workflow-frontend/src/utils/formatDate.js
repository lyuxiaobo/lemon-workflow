export function formatDate(cellValue) {
    if (cellValue != null) {
        let date = new Date(cellValue);
        let year = date.getFullYear();       //年
        let month = date.getMonth() + 1;     //月
        let day = date.getDate();            //日

        let hh = date.getHours();            //时
        let mm = date.getMinutes();          //分

        let clock = year + '-';

        if (month < 10)
            clock += '0';

        clock += month + '-';

        if (day < 10)
            clock += '0';

        clock += day + ' ';

        if (hh < 10)
            clock += '0';

        clock += hh + ':';
        if (mm < 10) clock += '0';
        clock += mm;

        return (clock);
    }
};
