webpackJsonp([4],{473:function(t,a,o){o(511);var n=o(185)(o(478),o(504),"data-v-e90b97f6",null);t.exports=n.exports},478:function(t,a,o){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default={data:function(){return{formulas:["log","sin","cos","tan"],formulaData:"",showFormulaData:""}},methods:{printFormula:function(t){this.formulaData+=t}},watch:{formulaData:function(){console.log(this.formulaData),this.showFormulaData=this.formulaData}}}},492:function(t,a,o){a=t.exports=o(82)(void 0),a.push([t.i,".grid-content[data-v-e90b97f6]{border:1px solid #e0e0e0;min-height:221px}",""])},504:function(t,a){t.exports={render:function(){var t=this,a=t.$createElement,o=t._self._c||a;return o("div",{attrs:{id:"main_panel"}},[o("el-row",[o("el-col",{attrs:{span:24}},t._l(t.formulas,function(a){return o("el-button",{key:a,on:{click:function(o){t.printFormula(a)}}},[t._v(t._s(a))])}))],1),t._v(" "),o("el-row",[o("el-col",{attrs:{span:24}},[o("div",{staticClass:"grid-content",attrs:{contenteditable:"true"},domProps:{textContent:t._s(t.formulaData)},on:{input:function(a){t.formulaData=a.target.innerText}}},[o("img",{attrs:{src:"https://www.baidu.com/img/bd_logo1.png"}}),t._v(t._s(t.showFormulaData))])])],1)],1)},staticRenderFns:[]}},511:function(t,a,o){var n=o(492);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);o(186)("2c5b71a8",n,!0)}});