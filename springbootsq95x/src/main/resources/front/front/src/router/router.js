import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import weixiuyuanList from '../pages/weixiuyuan/list'
import weixiuyuanDetail from '../pages/weixiuyuan/detail'
import weixiuyuanAdd from '../pages/weixiuyuan/add'
import loudongxinxiList from '../pages/loudongxinxi/list'
import loudongxinxiDetail from '../pages/loudongxinxi/detail'
import loudongxinxiAdd from '../pages/loudongxinxi/add'
import sushexinxiList from '../pages/sushexinxi/list'
import sushexinxiDetail from '../pages/sushexinxi/detail'
import sushexinxiAdd from '../pages/sushexinxi/add'
import sushefenpeiList from '../pages/sushefenpei/list'
import sushefenpeiDetail from '../pages/sushefenpei/detail'
import sushefenpeiAdd from '../pages/sushefenpei/add'
import baoxiuxinxiList from '../pages/baoxiuxinxi/list'
import baoxiuxinxiDetail from '../pages/baoxiuxinxi/detail'
import baoxiuxinxiAdd from '../pages/baoxiuxinxi/add'
import weixiudingdanList from '../pages/weixiudingdan/list'
import weixiudingdanDetail from '../pages/weixiudingdan/detail'
import weixiudingdanAdd from '../pages/weixiudingdan/add'
import weixiujinduList from '../pages/weixiujindu/list'
import weixiujinduDetail from '../pages/weixiujindu/detail'
import weixiujinduAdd from '../pages/weixiujindu/add'
import pingjiaxinxiList from '../pages/pingjiaxinxi/list'
import pingjiaxinxiDetail from '../pages/pingjiaxinxi/detail'
import pingjiaxinxiAdd from '../pages/pingjiaxinxi/add'
import zhishifenleiList from '../pages/zhishifenlei/list'
import zhishifenleiDetail from '../pages/zhishifenlei/detail'
import zhishifenleiAdd from '../pages/zhishifenlei/add'
import zhishixinxiList from '../pages/zhishixinxi/list'
import zhishixinxiDetail from '../pages/zhishixinxi/detail'
import zhishixinxiAdd from '../pages/zhishixinxi/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'weixiuyuan',
					component: weixiuyuanList
				},
				{
					path: 'weixiuyuanDetail',
					component: weixiuyuanDetail
				},
				{
					path: 'weixiuyuanAdd',
					component: weixiuyuanAdd
				},
				{
					path: 'loudongxinxi',
					component: loudongxinxiList
				},
				{
					path: 'loudongxinxiDetail',
					component: loudongxinxiDetail
				},
				{
					path: 'loudongxinxiAdd',
					component: loudongxinxiAdd
				},
				{
					path: 'sushexinxi',
					component: sushexinxiList
				},
				{
					path: 'sushexinxiDetail',
					component: sushexinxiDetail
				},
				{
					path: 'sushexinxiAdd',
					component: sushexinxiAdd
				},
				{
					path: 'sushefenpei',
					component: sushefenpeiList
				},
				{
					path: 'sushefenpeiDetail',
					component: sushefenpeiDetail
				},
				{
					path: 'sushefenpeiAdd',
					component: sushefenpeiAdd
				},
				{
					path: 'baoxiuxinxi',
					component: baoxiuxinxiList
				},
				{
					path: 'baoxiuxinxiDetail',
					component: baoxiuxinxiDetail
				},
				{
					path: 'baoxiuxinxiAdd',
					component: baoxiuxinxiAdd
				},
				{
					path: 'weixiudingdan',
					component: weixiudingdanList
				},
				{
					path: 'weixiudingdanDetail',
					component: weixiudingdanDetail
				},
				{
					path: 'weixiudingdanAdd',
					component: weixiudingdanAdd
				},
				{
					path: 'weixiujindu',
					component: weixiujinduList
				},
				{
					path: 'weixiujinduDetail',
					component: weixiujinduDetail
				},
				{
					path: 'weixiujinduAdd',
					component: weixiujinduAdd
				},
				{
					path: 'pingjiaxinxi',
					component: pingjiaxinxiList
				},
				{
					path: 'pingjiaxinxiDetail',
					component: pingjiaxinxiDetail
				},
				{
					path: 'pingjiaxinxiAdd',
					component: pingjiaxinxiAdd
				},
				{
					path: 'zhishifenlei',
					component: zhishifenleiList
				},
				{
					path: 'zhishifenleiDetail',
					component: zhishifenleiDetail
				},
				{
					path: 'zhishifenleiAdd',
					component: zhishifenleiAdd
				},
				{
					path: 'zhishixinxi',
					component: zhishixinxiList
				},
				{
					path: 'zhishixinxiDetail',
					component: zhishixinxiDetail
				},
				{
					path: 'zhishixinxiAdd',
					component: zhishixinxiAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
