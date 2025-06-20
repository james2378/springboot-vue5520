const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootsq95x/",
            name: "springbootsq95x",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootsq95x/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宿舍维修管理系统的设计与实现"
        } 
    }
}
export default base
