(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a687680"],{"00bf":function(t,a,n){var e=n("d2a6");"string"===typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);var i=n("499e").default;i("e342ff88",e,!0,{sourceMap:!1,shadowMode:!1})},1649:function(t,a,n){var e=n("73d1");"string"===typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);var i=n("499e").default;i("cd9f3d56",e,!0,{sourceMap:!1,shadowMode:!1})},"186b":function(t,a,n){"use strict";n("1649")},"466d":function(t,a,n){"use strict";var e=n("d784"),i=n("825a"),o=n("50c4"),r=n("1d80"),d=n("8aa5"),c=n("14c3");e("match",1,(function(t,a,n){return[function(a){var n=r(this),e=void 0==a?void 0:a[t];return void 0!==e?e.call(a,n):new RegExp(a)[t](String(n))},function(t){var e=n(a,t,this);if(e.done)return e.value;var r=i(t),s=String(this);if(!r.global)return c(r,s);var u=r.unicode;r.lastIndex=0;var v,b=[],l=0;while(null!==(v=c(r,s))){var f=String(v[0]);b[l]=f,""===f&&(r.lastIndex=d(s,o(r.lastIndex),u)),l++}return 0===l?null:b}]}))},"4dd2":function(t,a,n){"use strict";n.r(a);var e=function(){var t=this,a=t.$createElement,n=t._self._c||a;return n("div",{attrs:{id:"introduce"}},[n("a-tabs",{attrs:{"default-active-key":"1"},on:{change:t.callback}},[n("div",{staticClass:"match-tab-tag",attrs:{slot:"tabBarExtraContent"},slot:"tabBarExtraContent"},[t._v("选择比赛: ")]),t._l(t.intro_data,(function(a,e){return n("a-tab-pane",{key:(e+1).toString(),attrs:{tab:a.competitionName}},[n("div",{staticClass:"intro-box"},[n("h1",[t._v(t._s(a.competitionName)+" • 介绍")]),n("p",[t._v(" "+t._s(a.showContent)+" ")])])])}))],2)],1)},i=[],o=(n("ac1f"),n("466d"),{data:function(){return{intro_data:[]}},created:function(){this.getCompetIntro()},methods:{callback:function(t){},getCompetIntro:function(){var t=this;this.$api.match.getCompetIntro().then((function(a){200==a.data.code&&(t.intro_data=a.data.data)}))}}}),r=o,d=(n("6b8d"),n("186b"),n("2877")),c=Object(d["a"])(r,e,i,!1,null,"ae6148b4",null);a["default"]=c.exports},"6b8d":function(t,a,n){"use strict";n("00bf")},"73d1":function(t,a,n){var e=n("24fb");a=e(!1),a.push([t.i,"#introduce[data-v-ae6148b4]{margin:1.563vw 20.885vw;min-height:41.667vw;text-align:left}.intro-box[data-v-ae6148b4]{margin:2.604vw auto}h1[data-v-ae6148b4]{font-size:1.875vw;font-weight:700;text-align:center}p[data-v-ae6148b4]{font-size:.833vw;font-family:Adobe Heiti Std;font-weight:400;color:#050711;line-height:1.458vw;text-indent:2em}",""]),t.exports=a},d2a6:function(t,a,n){var e=n("24fb");a=e(!1),a.push([t.i,"#introduce[data-v-ae6148b4] .ant-tabs-nav-wrap{width:100%}#introduce[data-v-ae6148b4] .ant-tabs-nav-scroll{margin:0!important}#introduce[data-v-ae6148b4] .ant-tabs-nav-wrap{margin:0}#introduce[data-v-ae6148b4] .ant-tabs-tab{color:#222;background:rgba(0,0,0,.1);margin:0 1.563vw 0 0}#introduce[data-v-ae6148b4] .ant-tabs-tab,#introduce[data-v-ae6148b4] .ant-tabs-tab-active{display:inline-block;padding:.26vw .417vw;border-radius:.781vw}#introduce[data-v-ae6148b4] .ant-tabs-tab-active{color:#fff;background:#1b2751}#introduce[data-v-ae6148b4] .ant-tabs-ink-bar{background:transparent}#introduce[data-v-ae6148b4] .ant-tabs-extra-content{float:left!important;padding:.26vw .417vw;line-height:1.5em;margin-right:.521vw}",""]),t.exports=a}}]);