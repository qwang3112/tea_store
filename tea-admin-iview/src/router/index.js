import Vue from 'vue'
import VueRouter from 'vue-router'
import TeaCategoryManage from '../views/TeaCategoryManage'
import AddTeaCategory from '../views/AddTeaCategory'
import Index from '../views/Index'
import TeaCategoryUpdate from '../views/TeaCategoryUpdate'

import TeaInfoManage from '../views/TeaInfoManage'
import AddTeaInfo from '../views/AddTeaInfo'
import TeaInfoUpdate from '../views/TeaInfoUpdate'

Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    name:"Tea Manage",
    component:Index,
    show:true,
    redirect:"/TeaCategoryManage",
    children:[
      {
        path:"/TeaCategoryManage",
        name:"Search TeaCategory",
        component:TeaCategoryManage,
        show:true,
      },
      {
        path:"/AddTeaCategory",
        name:"AddTeaCategory",
        component:AddTeaCategory,
        show:true,
      },
      {
        path:"/TeaInfoManage",
        name:"Search TeaInfo",
        component:TeaInfoManage,
        show:true,
      },
      {
        path:"/AddTeaInfo",
        name:"AddTeaInfo",
        component:AddTeaInfo,
        show:true,
      }
    ]
  },
  {
    path:'/updateTeaCategory',
    component:TeaCategoryUpdate,
    show:false
  },
  {
    path:'/updateTeaInfo',
    component:TeaInfoUpdate,
    show:false
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
