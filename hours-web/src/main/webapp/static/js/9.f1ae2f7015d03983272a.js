webpackJsonp([9],{497:function(e,a,t){t(957);var r=t(195)(t(667),t(941),null,null);e.exports=r.exports},667:function(e,a,t){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default={data:function(){return{imageUrl:""}},methods:{handleAvatarSuccess:function(e,a){this.imageUrl=URL.createObjectURL(a.raw),this.$message({showClose:!0,message:"头像上传成功~",type:"success"})},beforeAvatarUpload:function(e){var a="image/jpeg"===e.type||"image/png"===e.type,t=e.size/1024/1024<2;return a||this.$message.error("上传头像图片只能是 JPG 或者 PNG 格式!"),t||this.$message.error("上传头像图片大小不能超过 2MB!"),a&&t}}}},677:function(e,a,t){a=e.exports=t(88)(void 0),a.push([e.i,".avatar-uploader .el-upload{border:1px dashed #d9d9d9;border-radius:6px;cursor:pointer;position:relative;overflow:hidden;width:178px}.avatar-uploader .el-upload:hover{border-color:#20a0ff}.avatar-uploader-icon{font-size:28px;color:#8c939d;width:178px;height:178px;line-height:178px;text-align:center}.avatar{width:178px;height:178px;display:block}",""])},941:function(e,a){e.exports={render:function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",[t("h3",[e._v("上传头像")]),e._v(" "),t("el-upload",{staticClass:"avatar-uploader",attrs:{action:"/api/user/icon","show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.imageUrl?t("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):t("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)},staticRenderFns:[]}},957:function(e,a,t){var r=t(677);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);t(196)("5883fc02",r,!0)}});