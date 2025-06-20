<template>
<div class="content">
	<div class="text" :style='{"margin":"50px auto","fontSize":"24px","color":"rgb(51, 51, 51)","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"0 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"15px 5px 5px 15px","display":"flex"}' v-if="isAuth('sushefenpei','首页总数')">
				<div :style='{"width":"40px","borderRadius":"15px 0 0 15px","background":"#deecfb","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{sushefenpeiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>宿舍分配总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"15px 5px 5px 15px","display":"flex"}' v-if="isAuth('baoxiuxinxi','首页总数')">
				<div :style='{"width":"40px","borderRadius":"15px 0 0 15px","background":"#deecfb","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{baoxiuxinxiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>报修信息总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"15px 5px 5px 15px","display":"flex"}' v-if="isAuth('pingjiaxinxi','首页总数')">
				<div :style='{"width":"40px","borderRadius":"15px 0 0 15px","background":"#deecfb","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{pingjiaxinxiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>评价信息总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 33.3%;margin: 0 10px;" v-if="isAuth('sushefenpei','首页统计')">
                <div id="sushefenpeiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 33.3%;margin: 0 10px;" v-if="isAuth('baoxiuxinxi','首页统计')">
                <div id="baoxiuxinxiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 33.3%;margin: 0 10px;" v-if="isAuth('pingjiaxinxi','首页统计')">
                <div id="pingjiaxinxiChart1" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//3
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            sushefenpeiCount: 0,
            baoxiuxinxiCount: 0,
            pingjiaxinxiCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getsushefenpeiCount();
    this.sushefenpeiChat1();
    this.getbaoxiuxinxiCount();
    this.baoxiuxinxiChat1();
    this.getpingjiaxinxiCount();
    this.pingjiaxinxiChat1();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getsushefenpeiCount() {
        this.$http({
            url: `sushefenpei/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.sushefenpeiCount = data.data
            }
        })
    },

    sushefenpeiChat1() {
      this.$nextTick(()=>{

        var sushefenpeiChart1 = echarts.init(document.getElementById("sushefenpeiChart1"),'macarons');
        this.$http({
            url: "sushefenpei/group/sushehao",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].sushehao);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].sushehao
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '宿舍人数统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                sushefenpeiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    sushefenpeiChart1.resize();
                };
            }
        });
      })
    },






    getbaoxiuxinxiCount() {
        this.$http({
            url: `baoxiuxinxi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.baoxiuxinxiCount = data.data
            }
        })
    },

    baoxiuxinxiChat1() {
      this.$nextTick(()=>{

        var baoxiuxinxiChart1 = echarts.init(document.getElementById("baoxiuxinxiChart1"),'macarons');
        this.$http({
            url: "baoxiuxinxi/group/shenqingriqi",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].shenqingriqi);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].shenqingriqi
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '每日报修人数统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        smooth: true
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                baoxiuxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    baoxiuxinxiChart1.resize();
                };
            }
        });
      })
    },






    getpingjiaxinxiCount() {
        this.$http({
            url: `pingjiaxinxi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.pingjiaxinxiCount = data.data
            }
        })
    },

    pingjiaxinxiChat1() {
      this.$nextTick(()=>{

        var pingjiaxinxiChart1 = echarts.init(document.getElementById("pingjiaxinxiChart1"),'macarons');
        this.$http({
            url: "pingjiaxinxi/group/manyidu",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].manyidu);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].manyidu
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: '满意度统计',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['25%', '55%'],
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                pingjiaxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    pingjiaxinxiChart1.resize();
                };
            }
        });
      })
    },






  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
