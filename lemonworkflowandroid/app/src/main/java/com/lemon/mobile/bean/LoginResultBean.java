package com.lemon.mobile.bean;

/**
 * @author Lyubo
 * @date 2021/8/10
 * Description:
 */
public class LoginResultBean {
    /**
     * msg : 成功
     * code : 200
     * data : {"groupName":null,"displayName":null,"userName":"admin","userId":"93a94a86-167f-4ebf-8c2e-00e0ff45de15"}
     */
    private String msg;
    private int code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * groupName : null
         * displayName : null
         * userName : admin
         * userId : 93a94a86-167f-4ebf-8c2e-00e0ff45de15
         */
        private String groupName;
        private String displayName;
        private String userName;
        private String userId;

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGroupName() {
            return groupName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserId() {
            return userId;
        }
    }
}
