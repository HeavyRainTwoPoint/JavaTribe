(function(e){function t(t){for(var a,o,i=t[0],s=t[1],u=t[2],f=0,d=[];f<i.length;f++)o=i[f],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&d.push(r[o][0]),r[o]=0;for(a in s)Object.prototype.hasOwnProperty.call(s,a)&&(e[a]=s[a]);l&&l(t);while(d.length)d.shift()();return c.push.apply(c,u||[]),n()}function n(){for(var e,t=0;t<c.length;t++){for(var n=c[t],a=!0,o=1;o<n.length;o++){var s=n[o];0!==r[s]&&(a=!1)}a&&(c.splice(t--,1),e=i(i.s=n[0]))}return e}var a={},r={app:0},c=[];function o(e){return i.p+"static/js/"+({}[e]||e)+"."+{"chunk-0402a733":"9c0a5d0a","chunk-08e26159":"f43856b8","chunk-0ddc81e8":"bbd3fd1a","chunk-2ecb0678":"045c46d2","chunk-355413d0":"486e6450","chunk-43c97ee4":"864a746c","chunk-46d489c2":"7edb6868","chunk-5614aa44":"04ea91f8","chunk-565dffee":"e203ec82","chunk-5a687680":"dd0a86bf","chunk-661c9f93":"5c636c9f","chunk-67276309":"367133e4","chunk-ed4c2a4e":"3761a326","chunk-708419ae":"3d72054d","chunk-7f3fddc5":"883d24ee","chunk-9c7e3084":"1fa1b020","chunk-f5c91c2a":"b7f505a5","chunk-fb2eb80e":"35a08ca1","chunk-fb7350ec":"c137c84e","chunk-fe6caf48":"3a49c288"}[e]+".js"}function i(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n=r[e];if(0!==n)if(n)t.push(n[2]);else{var a=new Promise((function(t,a){n=r[e]=[t,a]}));t.push(n[2]=a);var c,s=document.createElement("script");s.charset="utf-8",s.timeout=120,i.nc&&s.setAttribute("nonce",i.nc),s.src=o(e);var u=new Error;c=function(t){s.onerror=s.onload=null,clearTimeout(f);var n=r[e];if(0!==n){if(n){var a=t&&("load"===t.type?"missing":t.type),c=t&&t.target&&t.target.src;u.message="Loading chunk "+e+" failed.\n("+a+": "+c+")",u.name="ChunkLoadError",u.type=a,u.request=c,n[1](u)}r[e]=void 0}};var f=setTimeout((function(){c({type:"timeout",target:s})}),12e4);s.onerror=s.onload=c,document.head.appendChild(s)}return Promise.all(t)},i.m=e,i.c=a,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)i.d(n,a,function(t){return e[t]}.bind(null,a));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var l=u;c.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";n("3ebb")},"3ebb":function(e,t,n){var a=n("e31a");"string"===typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);var r=n("499e").default;r("517436b3",a,!0,{sourceMap:!1,shadowMode:!1})},4678:function(e,t,n){var a={"./af":"2bfb","./af.js":"2bfb","./ar":"8e73","./ar-dz":"a356","./ar-dz.js":"a356","./ar-kw":"423e","./ar-kw.js":"423e","./ar-ly":"1cfd","./ar-ly.js":"1cfd","./ar-ma":"0a84","./ar-ma.js":"0a84","./ar-sa":"8230","./ar-sa.js":"8230","./ar-tn":"6d83","./ar-tn.js":"6d83","./ar.js":"8e73","./az":"485c","./az.js":"485c","./be":"1fc1","./be.js":"1fc1","./bg":"84aa","./bg.js":"84aa","./bm":"a7fa","./bm.js":"a7fa","./bn":"9043","./bn-bd":"9686","./bn-bd.js":"9686","./bn.js":"9043","./bo":"d26a","./bo.js":"d26a","./br":"6887","./br.js":"6887","./bs":"2554","./bs.js":"2554","./ca":"d716","./ca.js":"d716","./cs":"3c0d","./cs.js":"3c0d","./cv":"03ec","./cv.js":"03ec","./cy":"9797","./cy.js":"9797","./da":"0f14","./da.js":"0f14","./de":"b469","./de-at":"b3eb","./de-at.js":"b3eb","./de-ch":"bb71","./de-ch.js":"bb71","./de.js":"b469","./dv":"598a","./dv.js":"598a","./el":"8d47","./el.js":"8d47","./en-au":"0e6b","./en-au.js":"0e6b","./en-ca":"3886","./en-ca.js":"3886","./en-gb":"39a6","./en-gb.js":"39a6","./en-ie":"e1d3","./en-ie.js":"e1d3","./en-il":"7333","./en-il.js":"7333","./en-in":"ec2e","./en-in.js":"ec2e","./en-nz":"6f50","./en-nz.js":"6f50","./en-sg":"b7e9","./en-sg.js":"b7e9","./eo":"65db","./eo.js":"65db","./es":"898b","./es-do":"0a3c","./es-do.js":"0a3c","./es-mx":"b5b7","./es-mx.js":"b5b7","./es-us":"55c9","./es-us.js":"55c9","./es.js":"898b","./et":"ec18","./et.js":"ec18","./eu":"0ff2","./eu.js":"0ff2","./fa":"8df4","./fa.js":"8df4","./fi":"81e9","./fi.js":"81e9","./fil":"d69a","./fil.js":"d69a","./fo":"0721","./fo.js":"0721","./fr":"9f26","./fr-ca":"d9f8","./fr-ca.js":"d9f8","./fr-ch":"0e49","./fr-ch.js":"0e49","./fr.js":"9f26","./fy":"7118","./fy.js":"7118","./ga":"5120","./ga.js":"5120","./gd":"f6b4","./gd.js":"f6b4","./gl":"8840","./gl.js":"8840","./gom-deva":"aaf2","./gom-deva.js":"aaf2","./gom-latn":"0caa","./gom-latn.js":"0caa","./gu":"e0c5","./gu.js":"e0c5","./he":"c7aa","./he.js":"c7aa","./hi":"dc4d","./hi.js":"dc4d","./hr":"4ba9","./hr.js":"4ba9","./hu":"5b14","./hu.js":"5b14","./hy-am":"d6b6","./hy-am.js":"d6b6","./id":"5038","./id.js":"5038","./is":"0558","./is.js":"0558","./it":"6e98","./it-ch":"6f12","./it-ch.js":"6f12","./it.js":"6e98","./ja":"079e","./ja.js":"079e","./jv":"b540","./jv.js":"b540","./ka":"201b","./ka.js":"201b","./kk":"6d79","./kk.js":"6d79","./km":"e81d","./km.js":"e81d","./kn":"3e92","./kn.js":"3e92","./ko":"22f8","./ko.js":"22f8","./ku":"2421","./ku.js":"2421","./ky":"9609","./ky.js":"9609","./lb":"440c","./lb.js":"440c","./lo":"b29d","./lo.js":"b29d","./lt":"26f9","./lt.js":"26f9","./lv":"b97c","./lv.js":"b97c","./me":"293c","./me.js":"293c","./mi":"688b","./mi.js":"688b","./mk":"6909","./mk.js":"6909","./ml":"02fb","./ml.js":"02fb","./mn":"958b","./mn.js":"958b","./mr":"39bd","./mr.js":"39bd","./ms":"ebe4","./ms-my":"6403","./ms-my.js":"6403","./ms.js":"ebe4","./mt":"1b45","./mt.js":"1b45","./my":"8689","./my.js":"8689","./nb":"6ce3","./nb.js":"6ce3","./ne":"3a39","./ne.js":"3a39","./nl":"facd","./nl-be":"db29","./nl-be.js":"db29","./nl.js":"facd","./nn":"b84c","./nn.js":"b84c","./oc-lnc":"167b","./oc-lnc.js":"167b","./pa-in":"f3ff","./pa-in.js":"f3ff","./pl":"8d57","./pl.js":"8d57","./pt":"f260","./pt-br":"d2d4","./pt-br.js":"d2d4","./pt.js":"f260","./ro":"972c","./ro.js":"972c","./ru":"957c","./ru.js":"957c","./sd":"6784","./sd.js":"6784","./se":"ffff","./se.js":"ffff","./si":"eda5","./si.js":"eda5","./sk":"7be6","./sk.js":"7be6","./sl":"8155","./sl.js":"8155","./sq":"c8f3","./sq.js":"c8f3","./sr":"cf1e","./sr-cyrl":"13e9","./sr-cyrl.js":"13e9","./sr.js":"cf1e","./ss":"52bd","./ss.js":"52bd","./sv":"5fbd","./sv.js":"5fbd","./sw":"74dc","./sw.js":"74dc","./ta":"3de5","./ta.js":"3de5","./te":"5cbb","./te.js":"5cbb","./tet":"576c","./tet.js":"576c","./tg":"3b1b","./tg.js":"3b1b","./th":"10e8","./th.js":"10e8","./tk":"5aff","./tk.js":"5aff","./tl-ph":"0f38","./tl-ph.js":"0f38","./tlh":"cf75","./tlh.js":"cf75","./tr":"0e81","./tr.js":"0e81","./tzl":"cf51","./tzl.js":"cf51","./tzm":"c109","./tzm-latn":"b53d","./tzm-latn.js":"b53d","./tzm.js":"c109","./ug-cn":"6117","./ug-cn.js":"6117","./uk":"ada2","./uk.js":"ada2","./ur":"5294","./ur.js":"5294","./uz":"2e8c","./uz-latn":"010e","./uz-latn.js":"010e","./uz.js":"2e8c","./vi":"2921","./vi.js":"2921","./x-pseudo":"fd7e","./x-pseudo.js":"fd7e","./yo":"7f33","./yo.js":"7f33","./zh-cn":"5c3a","./zh-cn.js":"5c3a","./zh-hk":"49ab","./zh-hk.js":"49ab","./zh-mo":"3a6c","./zh-mo.js":"3a6c","./zh-tw":"90ea","./zh-tw.js":"90ea"};function r(e){var t=c(e);return n(t)}function c(e){if(!n.o(a,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return a[e]}r.keys=function(){return Object.keys(a)},r.resolve=c,e.exports=r,r.id="4678"},"4a24":function(e,t,n){var a=n("24fb");t=a(!1),t.push([e.i,"*{box-sizing:border-box}",""]),e.exports=t},"56d7":function(e,t,n){"use strict";n.r(t);n("3db2"),n("450d");var a=n("58b8"),r=n.n(a),c=(n("186a"),n("301f")),o=n.n(c),i=(n("96dc"),n("9cea")),s=n.n(i),u=(n("e260"),n("e6cf"),n("cca6"),n("a79d"),n("2b0e")),f=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},l=[],d=(n("034f"),n("2877")),h={},p=Object(d["a"])(h,f,l,!1,null,null,null),b=p.exports,g=n("8c4f");u["default"].use(g["a"]);var m=[{path:"/",name:"Index",component:function(e){return n.e("chunk-43c97ee4").then(function(){var t=[n("0a0d")];e.apply(null,t)}.bind(this)).catch(n.oe)},redirect:"home/index",children:[{path:"/home/:path",name:"Home",component:function(e){return n.e("chunk-0402a733").then(function(){var t=[n("77b8")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-首页"}},{path:"/tribe/:path",name:"Tribe",component:function(e){return n.e("chunk-f5c91c2a").then(function(){var t=[n("c862")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-部落概况"}},{path:"/article",name:"Article",component:function(e){return n.e("chunk-fb7350ec").then(function(){var t=[n("fa20")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-技术文章"}},{path:"/technology/:path",name:"Technology",component:function(e){return n.e("chunk-9c7e3084").then(function(){var t=[n("f4a3")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-技术分享"}},{path:"/cooperation",name:"Cooperation",component:function(e){return n.e("chunk-0ddc81e8").then(function(){var t=[n("1833")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-合作交流"}},{path:"/match/:path",name:"Match",redirect:"/match/introduce",component:function(e){return n.e("chunk-708419ae").then(function(){var t=[n("c3be")];e.apply(null,t)}.bind(this)).catch(n.oe)},children:[{path:"/match/introduce",name:"introduce",component:function(e){return n.e("chunk-5a687680").then(function(){var t=[n("4dd2")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-比赛介绍"}},{path:"/match/award",name:"Award",component:function(e){return n.e("chunk-7f3fddc5").then(function(){var t=[n("529d")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-获奖名单"}},{path:"/match/achievement",name:"Award",component:function(e){return n.e("chunk-fb2eb80e").then(function(){var t=[n("a1f5")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-风采展示"}},{path:"/match/enroll",name:"Award",component:function(e){return n.e("chunk-fe6caf48").then(function(){var t=[n("de09")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-报名入口"}}]},{path:"/recruit/:path",name:"Recruit",component:function(e){return n.e("chunk-5614aa44").then(function(){var t=[n("1e5f")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-招新信息"}},{path:"/tribeLife",name:"TribeLife",component:function(e){return n.e("chunk-355413d0").then(function(){var t=[n("4db6")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-部落生活"}},{path:"/departments/:path",name:"Departments",redirect:"/departments/front",component:function(e){return Promise.all([n.e("chunk-67276309"),n.e("chunk-2ecb0678"),n.e("chunk-08e26159"),n.e("chunk-565dffee"),n.e("chunk-ed4c2a4e")]).then(function(){var t=[n("66b1")];e.apply(null,t)}.bind(this)).catch(n.oe)},children:[{path:"/departments/front",name:"Front",component:function(e){return n.e("chunk-565dffee").then(function(){var t=[n("da7f")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-前端组"}},{path:"/departments/back",name:"Back",component:function(e){return n.e("chunk-661c9f93").then(function(){var t=[n("545d")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-后端组"}},{path:"/departments/android",name:"Android",component:function(e){return n.e("chunk-2ecb0678").then(function(){var t=[n("6b54")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-安卓组"}},{path:"/departments/algorithm",name:"Algorithm",component:function(e){return n.e("chunk-67276309").then(function(){var t=[n("b78a")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-算法组"}},{path:"/departments/product",name:"Product",component:function(e){return n.e("chunk-08e26159").then(function(){var t=[n("f071")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-产品组"}},{path:"/departments/design",name:"Design",component:function(e){return n.e("chunk-46d489c2").then(function(){var t=[n("2d01")];e.apply(null,t)}.bind(this)).catch(n.oe)},meta:{title:"爪哇部落-设计组"}}]}]}],j=new g["a"]({routes:m});j.beforeEach((function(e,t,n){e.meta.title&&(document.title=e.meta.title),n()}));var v=j,y=(n("d3b7"),n("bc3a")),k=n.n(y),w=n("f64c"),x=k.a.create();x.defaults.baseURL="/",x.defaults.timeout=5e5,x.defaults.headers.post["Content-Type"]="application/x-www-form-urlencoded;charset=UTF-8",x.interceptors.request.use((function(e){return window.sessionStorage.getItem("token")&&(e.headers.token=JSON.parse(window.sessionStorage.getItem("token")).token),e}),(function(e){return Promise.reject(e)})),x.interceptors.response.use((function(e){return 200===e.status?(200!==e.data.code&&"SUCCESS"!==e.data.status&&w["a"].warn(e.data.message),Promise.resolve(e)):Promise.reject(e)}),(function(e){return w["a"].warn("请求失败，请刷新重试或联系客服人员"),Promise.reject(e)}));var z=x,S={loginIn:function(){return z.get("xxx/xx")}},P=S,T={getLifeInfos:function(){return z.get("/life/life-infos")}},M=T,_=(n("99af"),{getParentTags:function(){return z.get("/share/visit/getAllParentTags")},getIndexArticle:function(){return z.get("/share/visit/index?curPage=1&size=10")},getArticleDetail:function(e){return z.get("/share/visit/detail?artNo=".concat(e))},searchArticleTitle:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:10;return z.get("/share/visit/search?artTitle=".concat(e,"&curPage=").concat(t,"&size=").concat(n))},getExploreArticle:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:10;return z.get("/share/visit/index/explore/?tagId=".concat(e,"&curPage=").concat(t,"&size=").concat(n))},getSonTag:function(e){return z.get("/share/visit/getSonTagByParent?tagParent=".concat(e))}}),D=_,O={getRecruitDirection:function(){return z.get("/javatribe/enroll/admin/enroll_direction/query_list")},getDirectionInfo:function(e){return z.get("/javatribe/enroll/openapi/test_notice?direction_code="+e)},getDirectionNotice:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:4;return z.get("/javatribe/enroll/openapi/enroll_notice?last_n="+e)},getTestTitle:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:4;return z.get("/javatribe/enroll/openapi/enroll_notice?last_n="+e)},getDirectionTestList:function(e){return z.get("/javatribe/enroll/openapi/test_name?direction_code="+e)},uploadFile:function(e){return z.post("/javatribe/enroll/common/file_command/upload/enroll_test",e)}},$=O,A={getCooperation:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:0,n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:3;return z.get("/cooperation/page?type=".concat(e,"&&page=").concat(t,"&&size=").concat(n))}},N=A,E={getSynopsis:function(){return z.get("/introduction/history/findAll")},getSessionsLeader:function(){return z.get("/introduction/management/sessionsLeader")},getPresentManager:function(){return z.get("/introduction/management/presentManager")},getOffices:function(){return z.get("/introduction/office/findAll")}},I=E,L={getCompetIntro:function(){return z.get("competition/competition_introduce")},getSessionNum:function(e){return z.get("styleShowYears?competitionId="+e)},getStyleShow:function(){return z.get("front/styleshow_info")},getStyleTeam:function(e,t){return z.get("styleShow_searchBy?competitionId=".concat(e,"&yearId=").concat(t))},getListOfWinners:function(e,t){return z.get("competition/listOfWinners?competitionId=".concat(e,"&yearId=").concat(t))},getEnroll:function(){return z.get("competition/signUpKindsGet")},enroll:function(e){return z({method:"post",url:"competition/sign_up",headers:{"Content-Type":"application/json"},data:e})}},C=L,R={loginIn:function(){return z.get("xxx/xx")}},F=R,q={getTopNews:function(){return z.get("/news/getTopNews")},getPageNews:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:3;return z.get("/news/getLowPriorityPage?page=".concat(e,"&size=").concat(t))},getPriority:function(e){return z.get("/news/getCounts?priority=".concat(e))},postLogin:function(e){return z.post("/javatribe/common/user/login",e)}},H=q,U={login:P,tribeLife:M,technology:D,recruit:$,cooperation:N,tribe:I,match:C,department:F,home:H},Y=n("ed08"),B=n("f23d");n("202f"),n("d940"),n("499a");u["default"].use(s.a),u["default"].use(o.a),u["default"].use(r.a),u["default"].config.productionTip=!1,u["default"].prototype.$message=w["a"],u["default"].prototype.$api=U,u["default"].prototype.$utils=Y["a"],u["default"].use(B["a"]),new u["default"]({router:v,render:function(e){return e(b)}}).$mount("#app")},d940:function(e,t,n){var a=n("4a24");"string"===typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);var r=n("499e").default;r("5a59d6ac",a,!0,{sourceMap:!1,shadowMode:!1})},e31a:function(e,t,n){var a=n("24fb");t=a(!1),t.push([e.i,"#app{font-family:Avenir,Helvetica,Arial,sans-serif;-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale;text-align:center;color:#2c3e50}#nav{padding:1.563vw}#nav a{font-weight:700;color:#2c3e50}#nav a.router-link-exact-active{color:#42b983}",""]),e.exports=t},ed08:function(e,t,n){"use strict";n("c975"),n("a15b"),n("d81d"),n("d3b7"),n("4d63"),n("ac1f"),n("25f0"),n("5319"),n("841c"),n("1276");var a=function(e){e=new Date(e);var t=e.getFullYear(),n=e.getMonth()+1,a=e.getDate(),r=e.getHours(),o=e.getMinutes(),i=e.getSeconds();return[t,n,a].map(c).join("/")+" "+[r,o,i].map(c).join(":")};Date.prototype.format=function(e){var t={"M+":this.getMonth()+1,"d+":this.getDate(),"h+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};for(var n in/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length))),t)new RegExp("("+n+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[n]:("00"+t[n]).substr((""+t[n]).length)));return e};var r=function(){return(new Date).format("yyyy-MM-dd")},c=function(e){return e=e.toString(),e[1]?e:"0"+e},o=function(e){var t=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;return!!t.test(e)},i=function(e){return/^1(3\d|4\d|5\d|6\d|7\d|8\d|9\d)\d{8}$/g.test(e)},s=function(e){var t=e.substr(0,3)+"****"+e.substr(7);return t},u=function(e){var t=/^(\d{4})-(\d{2})-(\d{2})$/;return!!t.test(e)},f=function(e){var t=/^[0-9]+.?[0-9]*$/;return!!t.test(e)},l=function(e){var t=new RegExp("^[一-龥豈-鶴·]*$");return!!t.test(e)},d=function(e,t,n){return e.length>t&&e.length<n},h=function(e){for(var t=window.location.search.substring(1),n=t.split("&"),a=0;a<n.length;a++){var r=n[a].split("=");if(r[0]==e)return r[1]}return!1},p=function(e){var t=/^(\d+|\d+\.\d{1,2})$/;return!!t.test(e)},b=function(e){var t=/^(\d+|\d+\.\d{0,1})$/;return!!t.test(e)},g=function(e){var t=parseFloat(e);if(isNaN(t))return!1;t=Math.round(100*e)/100;var n=t.toString(),a=n.indexOf(".");a<0&&(a=n.length,n+=".");while(n.length<=a+2)n+="0";return n};function m(e,t){t=t||200;var n=null;return function(){var a=this,r=arguments;n&&clearTimeout(n),n=setTimeout((function(){n=null,e.apply(a,r)}),t)}}function j(e){var t=new Date(e),n=(t.getFullYear(),(t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1)+"-"),a=(t.getDate()<10?"0"+t.getDate():t.getDate())+" ";t.getHours(),t.getHours(),t.getMinutes(),t.getMinutes(),t.getSeconds(),t.getSeconds();return n+a}function v(e){var t=new Array("零","一","二","三","四","五","六","七","八","九"),n=new Array("","十","百","千","万","十","百","千","亿","十","百","千","万","十","百","千","亿");if(!e||isNaN(e))return"零";for(var a=e.toString().split(""),r="",c=0;c<a.length;c++){var o=a.length-1-c;r=n[c]+r;var i=a[o];r=t[i]+r}return r=r.replace(/零(千|百|十)/g,"零").replace(/十零/g,"十"),r=r.replace(/零+/g,"零"),r=r.replace(/零亿/g,"亿").replace(/零万/g,"万"),r=r.replace(/亿万/g,"亿"),r=r.replace(/零+$/,""),r=r.replace(/^一十/g,"十"),r}t["a"]={formatTime:a,toDecimal2:g,formatNumber2:p,formatNumber1:b,checknumber:f,checkName:l,checkPhone:i,checkDate:u,checkIdCard:o,_debounce:m,getCurrentTime:r,checkStringLength:d,loadStarPhone:s,getQueryVariable:h,formatDate:j,tranToChinaNum:v}}});