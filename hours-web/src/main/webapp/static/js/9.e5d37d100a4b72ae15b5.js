webpackJsonp([9],{496:function(e,t,a){a(996);var r=a(195)(a(677),a(976),"data-v-ca743e26",null);e.exports=r.exports},577:function(e,t,a){"use strict";function r(e,t){/(y+)/.test(t)&&(t=t.replace(RegExp.$1,(e.getFullYear()+"").substr(4-RegExp.$1.length)));var a={"M+":e.getMonth()+1,"d+":e.getDate(),"h+":e.getHours(),"m+":e.getMinutes(),"s+":e.getSeconds()};for(var r in a)if(new RegExp("("+r+")").test(t)){var o=a[r]+"";t=t.replace(RegExp.$1,1===RegExp.$1.length?o:i(o))}return t}function i(e){return("00"+e).substr(e.length)}t.a=r},677:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a(577);t.default={data:function(){return{form:{itemParamId:"",endTime:"",goalNum:"",creditRate:""},itemParams:[]}},created:function(){this.listItemParams()},methods:{onSubmit:function(){var e={};e.itemId=this.$route.params.itemId,e.goalNum=this.form.goalNum,e.creditRate=this.form.creditRate,e.endTime=a.i(r.a)(this.form.endTime,"yyyy/MM/dd hh:mm:ss"),e.itemParamId=this.form.itemParamId,this.$axios.post("/api/itemGoal",e).then(function(e){this.$message({message:"创建目标成功",type:"success"})}.bind(this))},listItemParams:function(){this.$axios.post("/api/itemParam/list","itemId="+this.$route.params.itemId).then(function(e){this.itemParams=e.data.data,console.log(this.itemParams)}.bind(this))}}}},707:function(e,t,a){t=e.exports=a(88)(void 0),t.push([e.i,"p>em[data-v-ca743e26]{display:block;margin-bottom:30px}",""])},976:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._m(0),e._v(" "),a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"截止时间"}},[a("el-col",{attrs:{span:8}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{editable:!1,type:"date"},model:{value:e.form.endTime,callback:function(t){e.form.endTime=t},expression:"form.endTime"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"目标参数"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.form.itemParamId,callback:function(t){e.form.itemParamId=t},expression:"form.itemParamId"}},e._l(e.itemParams,function(e,t){return a("el-option",{key:t,attrs:{label:e.displayName,value:e.id}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"目标数值"}},[a("el-col",{attrs:{span:8}},[a("el-input",{attrs:{type:"number"},model:{value:e.form.goalNum,callback:function(t){e.form.goalNum=t},expression:"form.goalNum"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"积分比率"}},[a("el-col",{attrs:{span:8}},[a("el-input",{attrs:{type:"number",placeholder:"每改变0.1,增加多少积分,填整数"},model:{value:e.form.creditRate,callback:function(t){e.form.creditRate=t},expression:"form.creditRate"}})],1)],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("确定")])],1)],1)],1)},staticRenderFns:[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("p",[a("em",[e._v("制定目标")])])}]}},996:function(e,t,a){var r=a(707);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);a(196)("aeaf4c3a",r,!0)}});