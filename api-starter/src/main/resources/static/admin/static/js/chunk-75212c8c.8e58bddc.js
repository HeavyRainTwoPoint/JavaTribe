(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-75212c8c"],{"1dde":function(e,t,a){var n=a("d039"),o=a("b622"),l=a("2d00"),r=o("species");e.exports=function(e){return l>=51||!n((function(){var t=[],a=t.constructor={};return a[r]=function(){return{foo:1}},1!==t[e](Boolean).foo}))}},"39c4":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-card",{staticClass:"box-card",attrs:{border:""}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",{staticClass:"title"},[e._v("数据列表")]),a("el-button",{staticClass:"button",on:{click:function(t){e.dialogAddVisible=!0}}},[e._v("+")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,border:"",highlightCurrentRow:!0,"element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[a("el-table-column",{attrs:{prop:"account",label:"账号",align:"center"}}),a("el-table-column",{attrs:{prop:"realName",label:"管理员姓名",align:"center"}}),a("el-table-column",{attrs:{label:"管理员等级",width:"180",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:1===t.row.userType?"info":2===t.row.userType?"warning":3===t.row.userType?"success":""}},[e._v(" "+e._s(t.row.typeName)+" ")])]}}])}),a("el-table-column",{attrs:{fixed:"right",label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return e.tableData.length>0?[a("el-button",{staticClass:"grey",attrs:{type:"text",icon:"el-icon-edit-outline"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v(" 编辑 ")]),a("el-button",{staticClass:"grey",attrs:{type:"text",icon:"el-icon-delete-solid"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v(" 删除 ")])]:void 0}}],null,!0)})],1)],1),a("div",{staticClass:"operationHide"},[a("el-dialog",{attrs:{title:"添加",visible:e.dialogAddVisible},on:{"update:visible":function(t){e.dialogAddVisible=t}}},[a("el-form",{attrs:{"label-width":"100px",model:e.addForm}},[a("el-form-item",{attrs:{label:"管理员账号"}},[a("el-input",{model:{value:e.addForm.account,callback:function(t){e.$set(e.addForm,"account",t)},expression:"addForm.account"}})],1),a("el-form-item",{attrs:{label:"管理员姓名"}},[a("el-input",{model:{value:e.addForm.realName,callback:function(t){e.$set(e.addForm,"realName",t)},expression:"addForm.realName"}})],1),a("el-form-item",{attrs:{label:"管理员级别"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.addForm.userType,callback:function(t){e.$set(e.addForm,"userType",t)},expression:"addForm.userType"}},e._l(e.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogAddVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.add}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"编辑",visible:e.dialogChangeVisible},on:{"update:visible":function(t){e.dialogChangeVisible=t}}},[a("el-form",{attrs:{"label-width":"100px",model:e.updateForm}},[a("el-form-item",{attrs:{label:"添加管理员"}},[a("el-input",{model:{value:e.updateForm.account,callback:function(t){e.$set(e.updateForm,"account",t)},expression:"updateForm.account"}})],1),a("el-form-item",{attrs:{label:"管理员姓名"}},[a("el-input",{model:{value:e.updateForm.realName,callback:function(t){e.$set(e.updateForm,"realName",t)},expression:"updateForm.realName"}})],1),a("el-form-item",{attrs:{label:"管理员级别"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.updateForm.typeName,callback:function(t){e.$set(e.updateForm,"typeName",t)},expression:"updateForm.typeName"}},e._l(e.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogChangeVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.update}},[e._v("确 定")])],1)],1)],1)],1)},o=[],l=(a("d3b7"),a("d81d"),a("a434"),{name:"admin",data:function(){return{tableData:[],loading:!1,dialogAddVisible:!1,dialogChangeVisible:!1,addForm:{},updateForm:{},options:[{value:"1",label:"用户"},{value:"2",label:"管理员"},{value:"3",label:"超级管理员"}]}},created:function(){this.getData()},methods:{getData:function(){var e=this;this.loading=!0,this.$http.get("/javatribe/common/user/admin/list").then((function(t){e.tableData=t.data.map((function(e){return 1==e.userType?e.typeName="用户":2==e.userType?e.typeName="管理员":3==e.userType&&(e.typeName="超级管理员"),e}))})).catch((function(t){e.$message.error("网络异常，请稍后重试")})).finally((function(){e.loading=!1}))},handleDelete:function(e,t){var a=this;this.$confirm("确定删除这一个管理员吗？","提示",{type:"warning"}).then((function(){a.$http.post("/javatribe/common/user/update",{id:t.id,account:t.account,deleteMark:1}).then((function(t){a.$message({message:"成功删除这个管理员",type:"success"}),a.tableData.splice(e,1)}))})).catch((function(){}))},handleEdit:function(e,t){this.updateForm=JSON.parse(JSON.stringify(t)),this.dialogChangeVisible=!0},add:function(){var e=this,t=this.addForm,a=t.account,n=t.realName,o=t.userType;"undefined"==typeof a?this.$message.warning("请输入学号"):"undefined"==typeof n?this.$message.warning("请输入真实姓名"):"undefined"==typeof o?this.$message.warning("请选择管理员级别"):this.$http.post("/javatribe/common/user/update",{account:a,realName:n,userType:o,deleteMark:0}).then((function(t){e.$message({message:"成功添加一个管理员",type:"success"}),e.addForm={},e.getData(),e.dialogAddVisible=!1}))},update:function(){var e=this,t=this.updateForm,a=t.account,n=t.realName,o=t.typeName,l=t.id;this.$http.post("/javatribe/common/user/update",{id:l,account:a,realName:n,userType:o}).then((function(t){e.$message({message:"成功修改管理员信息",type:"success"}),e.addForm={},e.getData(),e.dialogChangeVisible=!1}))}}}),r=l,i=(a("8557"),a("2877")),s=Object(i["a"])(r,n,o,!1,null,"6c578b58",null);t["default"]=s.exports},"65f0":function(e,t,a){var n=a("861d"),o=a("e8b5"),l=a("b622"),r=l("species");e.exports=function(e,t){var a;return o(e)&&(a=e.constructor,"function"!=typeof a||a!==Array&&!o(a.prototype)?n(a)&&(a=a[r],null===a&&(a=void 0)):a=void 0),new(void 0===a?Array:a)(0===t?0:t)}},8137:function(e,t,a){},8418:function(e,t,a){"use strict";var n=a("c04e"),o=a("9bf2"),l=a("5c6c");e.exports=function(e,t,a){var r=n(t);r in e?o.f(e,r,l(0,a)):e[r]=a}},8557:function(e,t,a){"use strict";a("8137")},a434:function(e,t,a){"use strict";var n=a("23e7"),o=a("23cb"),l=a("a691"),r=a("50c4"),i=a("7b0b"),s=a("65f0"),c=a("8418"),u=a("1dde"),d=u("splice"),p=Math.max,f=Math.min,m=9007199254740991,b="Maximum allowed length exceeded";n({target:"Array",proto:!0,forced:!d},{splice:function(e,t){var a,n,u,d,g,h,v=i(this),y=r(v.length),w=o(e,y),x=arguments.length;if(0===x?a=n=0:1===x?(a=0,n=y-w):(a=x-2,n=f(p(l(t),0),y-w)),y+a-n>m)throw TypeError(b);for(u=s(v,n),d=0;d<n;d++)g=w+d,g in v&&c(u,d,v[g]);if(u.length=n,a<n){for(d=w;d<y-n;d++)g=d+n,h=d+a,g in v?v[h]=v[g]:delete v[h];for(d=y;d>y-n+a;d--)delete v[d-1]}else if(a>n)for(d=y-n;d>w;d--)g=d+n-1,h=d+a-1,g in v?v[h]=v[g]:delete v[h];for(d=0;d<a;d++)v[d+w]=arguments[d+2];return v.length=y-n+a,u}})},b727:function(e,t,a){var n=a("0366"),o=a("44ad"),l=a("7b0b"),r=a("50c4"),i=a("65f0"),s=[].push,c=function(e){var t=1==e,a=2==e,c=3==e,u=4==e,d=6==e,p=7==e,f=5==e||d;return function(m,b,g,h){for(var v,y,w=l(m),x=o(w),F=n(b,g,3),k=r(x.length),N=0,$=h||i,C=t?$(m,k):a||p?$(m,0):void 0;k>N;N++)if((f||N in x)&&(v=x[N],y=F(v,N,w),e))if(t)C[N]=y;else if(y)switch(e){case 3:return!0;case 5:return v;case 6:return N;case 2:s.call(C,v)}else switch(e){case 4:return!1;case 7:s.call(C,v)}return d?-1:c||u?u:C}};e.exports={forEach:c(0),map:c(1),filter:c(2),some:c(3),every:c(4),find:c(5),findIndex:c(6),filterOut:c(7)}},d81d:function(e,t,a){"use strict";var n=a("23e7"),o=a("b727").map,l=a("1dde"),r=l("map");n({target:"Array",proto:!0,forced:!r},{map:function(e){return o(this,e,arguments.length>1?arguments[1]:void 0)}})},e8b5:function(e,t,a){var n=a("c6b6");e.exports=Array.isArray||function(e){return"Array"==n(e)}}}]);