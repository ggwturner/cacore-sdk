/*
	Copyright (c) 2004-2011, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/

//>>built
define("dojo/dnd/Avatar",["../_base/declare","../_base/window","../dom","../dom-attr","../dom-class","../dom-construct","../query"],function(_1,_2,_3,_4,_5,_6,_7){return _1("dojo.dnd.Avatar",null,{constructor:function(_8){this.manager=_8;this.construct();},construct:function(){this.isA11y=_5.contains(_2.body(),"dijit_a11y");var a=_6.create("table",{"class":"dojoDndAvatar",style:{position:"absolute",zIndex:"1999",margin:"0px"}}),_9=this.manager.source,_a,b=_6.create("tbody",null,a),tr=_6.create("tr",null,b),td=_6.create("td",null,tr),_b=this.isA11y?_6.create("span",{id:"a11yIcon",innerHTML:this.manager.copy?"+":"<"},td):null,_c=_6.create("span",{innerHTML:_9.generateText?this._generateText():""},td),k=Math.min(5,this.manager.nodes.length),i=0;_4.set(tr,{"class":"dojoDndAvatarHeader",style:{opacity:0.9}});for(;i<k;++i){if(_9.creator){_a=_9._normalizedCreator(_9.getItem(this.manager.nodes[i].id).data,"avatar").node;}else{_a=this.manager.nodes[i].cloneNode(true);if(_a.tagName.toLowerCase()=="tr"){var _d=_6.create("table"),_e=_6.create("tbody",null,_d);_e.appendChild(_a);_a=_d;}}_a.id="";tr=_6.create("tr",null,b);td=_6.create("td",null,tr);td.appendChild(_a);_4.set(tr,{"class":"dojoDndAvatarItem",style:{opacity:(9-i)/10}});}this.node=a;},destroy:function(){_6.destroy(this.node);this.node=false;},update:function(){dojo[(this.manager.canDropFlag?"add":"remove")+"Class"](this.node,"dojoDndAvatarCanDrop");if(this.isA11y){var _f=_3.byId("a11yIcon");var _10="+";if(this.manager.canDropFlag&&!this.manager.copy){_10="< ";}else{if(!this.manager.canDropFlag&&!this.manager.copy){_10="o";}else{if(!this.manager.canDropFlag){_10="x";}}}_f.innerHTML=_10;}_7(("tr.dojoDndAvatarHeader td span"+(this.isA11y?" span":"")),this.node).forEach(function(_11){_11.innerHTML=this._generateText();},this);},_generateText:function(){return this.manager.nodes.length.toString();}});});