webpackJsonp([8],{489:function(t,e,a){a(941);var r=a(195)(a(655),a(929),"data-v-1d9dd140",null);t.exports=r.exports},655:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){return{form:{itemParams:[{itemId:this.$route.params.itemId,displayName:"",unit:""}]}}},methods:{addItemParam:function(){this.form.itemParams.push({itemId:this.$route.params.itemId,displayName:"",unit:""})},deleteItemParam:function(t){this.form.itemParams.splice(t,1)},onSubmit:function(){this.$axios.post("/api/itemParam",this.form.itemParams).then(function(t){var e=t.data;"0"===e.resultCode?(this.$message({message:"恭喜,添加属性成功",type:"success"}),this.$router.push({name:"itemList"})):this.$message.error(e.resultMessage)}.bind(this)).catch(function(t){return console.log(t)})}}}},669:function(t,e,a){e=t.exports=a(88)(void 0),e.push([t.i,"#itemParams[data-v-1d9dd140]{border:1px solid #eaeefb;border-radius:4px;transition:.2s}.paramForm[data-v-1d9dd140]{border:1px solid #eaeefb;border-radius:4px;transition:.2s;margin:20px;padding:10px}.paramForm[data-v-1d9dd140]:hover{border:1px solid #13ce66;border-radius:4px;transition:.2s;margin:20px;padding:10px}",""])},929:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-form",{ref:"form",attrs:{model:t.form,"label-width":"80px"}},[a("el-button",{staticStyle:{"margin-bottom":"5px"},on:{click:function(e){t.addItemParam()}}},[t._v("添加记录参数")]),t._v(" "),a("div",{attrs:{id:"itemParams"}},[a("el-row",t._l(t.form.itemParams,function(e,r){return a("el-col",{key:r,attrs:{span:8}},[a("el-form",{ref:"form",refInFor:!0,staticClass:"paramForm",attrs:{model:e,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"文案"}},[a("el-col",{attrs:{span:8}},[a("el-input",{model:{value:e.displayName,callback:function(t){e.displayName=t},expression:"o.displayName"}})],1)],1),t._v(" "),a("el-form-item",{attrs:{label:"单位"}},[a("el-col",{attrs:{span:8}},[a("el-input",{model:{value:e.unit,callback:function(t){e.unit=t},expression:"o.unit"}})],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{push:20}},[a("el-button",{attrs:{icon:"delete"},on:{click:function(e){t.deleteItemParam(r)}}})],1)],1)],1)],1)}))],1)],1),t._v(" "),a("el-button",{staticStyle:{"margin-top":"5px"},attrs:{size:"large",type:"danger"},on:{click:function(e){t.onSubmit()}}},[t._v("完成添加")])],1)},staticRenderFns:[]}},941:function(t,e,a){var r=a(669);"string"==typeof r&&(r=[[t.i,r,""]]),r.locals&&(t.exports=r.locals);a(196)("6a366c4c",r,!0)}});