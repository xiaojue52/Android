prompt PL/SQL Developer import file
prompt Created on 2014年2月24日 by Administrator
set feedback off
set define off
prompt Disabling triggers for JY_ALARM...
alter table JY_ALARM disable all triggers;
prompt Disabling triggers for JY_CABINET...
alter table JY_CABINET disable all triggers;
prompt Disabling triggers for JY_DEVICE...
alter table JY_DEVICE disable all triggers;
prompt Disabling triggers for JY_CONSTANT...
alter table JY_CONSTANT disable all triggers;
prompt Disabling triggers for JY_ALARM_TYPE...
alter table JY_ALARM_TYPE disable all triggers;
prompt Disabling triggers for JY_ALARM_TYPE_COLLECT...
alter table JY_ALARM_TYPE_COLLECT disable all triggers;
prompt Disabling triggers for JY_LINE...
alter table JY_LINE disable all triggers;
prompt Disabling triggers for JY_USER_GROUP...
alter table JY_USER_GROUP disable all triggers;
prompt Disabling triggers for JY_CABINET_HISTORY...
alter table JY_CABINET_HISTORY disable all triggers;
prompt Disabling triggers for JY_DETECTOR...
alter table JY_DETECTOR disable all triggers;
prompt Disabling triggers for JY_HISTORY...
alter table JY_HISTORY disable all triggers;
prompt Disabling triggers for JY_HISTORY_CHART...
alter table JY_HISTORY_CHART disable all triggers;
prompt Disabling triggers for JY_HISTORY_MONTH_CHART...
alter table JY_HISTORY_MONTH_CHART disable all triggers;
prompt Disabling triggers for JY_KEY_GENERATOR...
alter table JY_KEY_GENERATOR disable all triggers;
prompt Disabling triggers for JY_USER...
alter table JY_USER disable all triggers;
prompt Disabling foreign key constraints for JY_ALARM...
alter table JY_ALARM disable constraint FK11047F41807F4191;
prompt Disabling foreign key constraints for JY_CABINET...
alter table JY_CABINET disable constraint FK38F2EB484CDFBDA3;
alter table JY_CABINET disable constraint FK38F2EB485F790DD;
alter table JY_CABINET disable constraint FK38F2EB48A286E91;
alter table JY_CABINET disable constraint FK38F2EB48A2C603DB;
alter table JY_CABINET disable constraint FK38F2EB48AF055F4C;
alter table JY_CABINET disable constraint FK38F2EB48D53330F2;
prompt Disabling foreign key constraints for JY_DEVICE...
alter table JY_DEVICE disable constraint FK4AEBCB464CDFBDA3;
alter table JY_DEVICE disable constraint FK4AEBCB46D2758917;
prompt Disabling foreign key constraints for JY_ALARM_TYPE...
alter table JY_ALARM_TYPE disable constraint FK1D4F2978A288F1CD;
prompt Disabling foreign key constraints for JY_ALARM_TYPE_COLLECT...
alter table JY_ALARM_TYPE_COLLECT disable constraint FK995139639C859685;
alter table JY_ALARM_TYPE_COLLECT disable constraint FK995139639C860AE4;
alter table JY_ALARM_TYPE_COLLECT disable constraint FK995139639C867F43;
alter table JY_ALARM_TYPE_COLLECT disable constraint FK995139639C86F3A2;
prompt Disabling foreign key constraints for JY_CABINET_HISTORY...
alter table JY_CABINET_HISTORY disable constraint FK52CBFABDD2758917;
prompt Disabling foreign key constraints for JY_DETECTOR...
alter table JY_DETECTOR disable constraint FK3B8448B6807F4191;
alter table JY_DETECTOR disable constraint FK3B8448B6AF65B483;
prompt Disabling foreign key constraints for JY_HISTORY...
alter table JY_HISTORY disable constraint FKFE90D9A4AC8401D1;
alter table JY_HISTORY disable constraint FKFE90D9A4D40CE0B1;
prompt Disabling foreign key constraints for JY_HISTORY_CHART...
alter table JY_HISTORY_CHART disable constraint FK86084983AC8401D1;
prompt Disabling foreign key constraints for JY_HISTORY_MONTH_CHART...
alter table JY_HISTORY_MONTH_CHART disable constraint FK9BE05F44AC8401D1;
prompt Disabling foreign key constraints for JY_USER...
alter table JY_USER disable constraint FKBB4090BBAC020558;
prompt Deleting JY_USER...
delete from JY_USER;
commit;
prompt Deleting JY_KEY_GENERATOR...
delete from JY_KEY_GENERATOR;
commit;
prompt Deleting JY_HISTORY_MONTH_CHART...
delete from JY_HISTORY_MONTH_CHART;
commit;
prompt Deleting JY_HISTORY_CHART...
delete from JY_HISTORY_CHART;
commit;
prompt Deleting JY_HISTORY...
delete from JY_HISTORY;
commit;
prompt Deleting JY_DETECTOR...
delete from JY_DETECTOR;
commit;
prompt Deleting JY_CABINET_HISTORY...
delete from JY_CABINET_HISTORY;
commit;
prompt Deleting JY_USER_GROUP...
delete from JY_USER_GROUP;
commit;
prompt Deleting JY_LINE...
delete from JY_LINE;
commit;
prompt Deleting JY_ALARM_TYPE_COLLECT...
delete from JY_ALARM_TYPE_COLLECT;
commit;
prompt Deleting JY_ALARM_TYPE...
delete from JY_ALARM_TYPE;
commit;
prompt Deleting JY_CONSTANT...
delete from JY_CONSTANT;
commit;
prompt Deleting JY_DEVICE...
delete from JY_DEVICE;
commit;
prompt Deleting JY_CABINET...
delete from JY_CABINET;
commit;
prompt Deleting JY_ALARM...
delete from JY_ALARM;
commit;
prompt Loading JY_ALARM...
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('1770118834540', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device4', '3', 15);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('1770223089018', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '3', 12);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('1770295560075', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device6', '3', 10);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('1811655363008', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device1', '3', 4);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('1811729352533', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device2', '3', 10);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23324522699384', '离线', null, null, '0', to_timestamp('17-01-2014 15:04:11.631000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23405851302545', '离线', null, null, '0', to_timestamp('17-01-2014 15:05:32.985000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23416083375203', '离线', null, null, '0', to_timestamp('17-01-2014 15:05:43.203000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23467028963345', '离线', null, null, '0', to_timestamp('17-01-2014 15:06:34.168000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('5230700389330', '离线', null, null, '0', to_timestamp('24-01-2014 09:59:13.038000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('5576497909661', '离线', null, null, '0', to_timestamp('24-01-2014 10:04:58.881000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23404079830599', '离线', null, null, '0', to_timestamp('27-01-2014 14:57:52.037000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23414268347937', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:02.207000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23414429919373', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:02.363000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23424690736130', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:12.638000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23424768436064', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:12.720000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23434908451404', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:22.865000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23434989584053', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:22.945000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23445134250717', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:33.089000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23445237660541', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:33.196000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23455419868875', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:43.373000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23455498515226', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:43.458000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23465643670493', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:53.603000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23465754736883', '离线', null, null, '0', to_timestamp('27-01-2014 14:58:53.703000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23475897078778', '离线', null, null, '0', to_timestamp('27-01-2014 14:59:03.854000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23475973010370', '离线', null, null, '0', to_timestamp('27-01-2014 14:59:03.934000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23486097541233', '离线', null, null, '0', to_timestamp('27-01-2014 14:59:14.055000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23486160319363', '离线', null, null, '0', to_timestamp('27-01-2014 14:59:14.125000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25378145242277', '离线', null, null, '0', to_timestamp('26-01-2014 15:30:45.523000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('11013687828246', 'A相C相温度高于设定值(15.0℃)<br>', null, null, '0', to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device7', '3', 2);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('11014436595132', 'A相温度高于设定值(15.0℃)<br>三相之间温差超出设定值(25.0℃)<br>', null, null, '0', to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device8', '3', 2);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('11014547370591', 'A相B相C相温度高于设定值(15.0℃)<br>', null, null, '0', to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device9', '3', 2);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('12238744173552', '离线', null, null, '0', to_timestamp('21-01-2014 11:55:36.284000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26633078234290', '温度无法解析', null, null, '0', to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '6', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26633108022445', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device6', '3', 8);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('27837264271929', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('27855908625740', '温度无法解析', null, null, '0', to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '6', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('27875151794826', '温度无法解析', null, null, '0', to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '6', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('27881632689505', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22942405893043', '离线', null, null, '0', to_timestamp('07-02-2014 14:55:11.727000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('2265079943366', '离线', null, null, '0', to_timestamp('21-01-2014 09:09:30.272000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('2265285885249', '离线', null, null, '0', to_timestamp('21-01-2014 09:09:30.506000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('2316533606654', '离线', null, null, '0', to_timestamp('21-01-2014 09:10:21.777000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('2436998728734', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device3', '3', 4);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('2438367160566', '离线', null, null, '0', to_timestamp('21-01-2014 09:12:23.603000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('4796912714285', '离线', null, null, '0', to_timestamp('22-01-2014 09:52:31.479000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('4797122799361', '离线', null, null, '0', to_timestamp('22-01-2014 09:52:31.775000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('3113846457270', '离线', null, null, '0', to_timestamp('26-01-2014 09:19:41.437000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25486042863651', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device4', '3', 3);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25486115595450', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '3', 3);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25565445680057', '终端重复（号码：18765432123：18765434567）', null, null, '0', to_timestamp('26-01-2014 15:33:52.836000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25570035162910', '离线', null, null, '0', to_timestamp('26-01-2014 15:33:57.426000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25666136000317', '终端重复（号码：18766565656：18765432345）', null, null, '0', to_timestamp('26-01-2014 15:35:33.523000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25671023743431', '离线', null, null, '0', to_timestamp('26-01-2014 15:35:38.423000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25673258717771', 'A相C相温度高于设定值(15.0℃)<br>三相之间温差超出设定值(25.0℃)<br>三相与环境温差超出设定值(35.0℃)', null, null, '0', to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device7', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25673323233900', 'A相B相温度高于设定值(15.0℃)<br>三相之间温差超出设定值(25.0℃)<br>三相与环境温差超出设定值(35.0℃)', null, null, '0', to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device8', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25673388641116', 'A相B相温度高于设定值(15.0℃)<br>三相之间温差超出设定值(25.0℃)<br>三相与环境温差超出设定值(35.0℃)', null, null, '0', to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device9', '3', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25852700596988', '离线', null, null, '0', to_timestamp('26-01-2014 15:38:40.101000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('25983942726797', '离线', null, null, '0', to_timestamp('26-01-2014 15:40:51.345000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('5087341272978', 'C相:15分钟内温度变化超过设定值（15.0℃）<br>', null, null, '0', to_timestamp('21-01-2014 09:56:32.695000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device1', '4', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('5331785916484', '离线', null, null, '0', to_timestamp('21-01-2014 10:00:37.064000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('12006488969574', '离线', null, null, '0', to_timestamp('21-01-2014 11:51:43.958000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('7908894205107', '离线', null, null, '0', to_timestamp('24-01-2014 10:43:51.298000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('9089195189254', '离线', null, null, '0', to_timestamp('24-01-2014 11:03:31.569000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('9221687098537', '离线', null, null, '0', to_timestamp('24-01-2014 11:05:44.105000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('9231884524715', '离线', null, null, '0', to_timestamp('24-01-2014 11:05:54.306000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '0', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26058188010843', '间隔3故障', null, null, '0', to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device6', '6', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('28646001530995', 'C相:15分钟内温度变化超过设定值（15.0℃）<br>', null, null, '0', to_timestamp('24-01-2014 16:29:28.867000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device4', '4', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('28646243497952', 'A相:15分钟内温度变化超过设定值（15.0℃）<br>', null, null, '0', to_timestamp('24-01-2014 16:29:29.117000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device5', '4', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('12954532509951', '离线', null, null, '0', to_timestamp('26-01-2014 12:03:42.526000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('12998157709464', '三相之间温差超出设定值(15.0℃)<br>', null, null, '0', to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', 'Device1', '3', 3);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22405244787006', '离线', null, null, '0', to_timestamp('26-01-2014 14:41:13.754000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22828108534579', '离线', null, null, '0', to_timestamp('26-01-2014 14:48:16.631000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22848627971387', '离线', null, null, '0', to_timestamp('26-01-2014 14:48:37.122000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23007366311287', '离线', null, null, '0', to_timestamp('26-01-2014 14:51:15.886000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23149871574591', '离线', null, null, '0', to_timestamp('27-01-2014 14:53:37.824000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23149962521691', '离线', null, null, '0', to_timestamp('27-01-2014 14:53:37.894000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23363425209597', '离线', null, null, '0', to_timestamp('27-01-2014 14:57:11.380000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('23403987595729', '离线', null, null, '0', to_timestamp('27-01-2014 14:57:51.936000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26034460956600', '离线', null, null, '0', to_timestamp('26-01-2014 15:41:41.857000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device7', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26405259440190', '故障', null, null, '0', to_timestamp('26-01-2014 15:47:52.678000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '2', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26408531572012', '离线', null, null, '0', to_timestamp('26-01-2014 15:47:55.948000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26451837744072', '故障', null, null, '0', to_timestamp('26-01-2014 15:48:39.260000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '2', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('26459145372125', '离线', null, null, '0', to_timestamp('26-01-2014 15:48:46.570000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('29225714682142', '离线', null, null, '0', to_timestamp('26-01-2014 16:34:53.221000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('30620161617842', '离线', null, null, '0', to_timestamp('26-01-2014 16:58:07.718000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('18594736003084', '离线', null, null, '0', to_timestamp('07-02-2014 13:42:43.891000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('18605082768018', '离线', null, null, '0', to_timestamp('07-02-2014 13:42:54.249000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19131924090718', '离线', null, null, '0', to_timestamp('07-02-2014 13:51:41.104000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19142277981226', '离线', null, null, '0', to_timestamp('07-02-2014 13:51:51.446000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19331018605736', '离线', null, null, '0', to_timestamp('07-02-2014 13:55:00.180000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19341457859882', '离线', null, null, '0', to_timestamp('07-02-2014 13:55:10.633000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19546667793651', '离线', null, null, '0', to_timestamp('07-02-2014 13:58:35.848000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19597922696749', '离线', null, null, '0', to_timestamp('07-02-2014 13:59:27.107000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19608249076004', '离线', null, null, '0', to_timestamp('07-02-2014 13:59:37.438000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19835613152212', '离线', null, null, '0', to_timestamp('07-02-2014 14:03:24.812000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('19846054813230', '离线', null, null, '0', to_timestamp('07-02-2014 14:03:35.243000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('20538958729328', '离线', null, null, '0', to_timestamp('07-02-2014 14:15:08.181000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('20868930946778', '离线', null, null, '0', to_timestamp('07-02-2014 14:20:38.170000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('20879076425103', '离线', null, null, '0', to_timestamp('07-02-2014 14:20:48.301000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
commit;
prompt 100 records committed...
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('21439327616603', '离线', null, null, '0', to_timestamp('07-02-2014 14:30:08.577000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('21449431983108', '离线', null, null, '0', to_timestamp('07-02-2014 14:30:18.688000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22211022137064', '离线', null, null, '0', to_timestamp('07-02-2014 14:43:00.315000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('22211157941941', '离线', null, null, '0', to_timestamp('07-02-2014 14:43:00.452000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device1', '1', 1);
insert into JY_ALARM (ID, ALARM_TEXT, NOTE, REPAIR_USER, STATUS, C_DATE, ISCABINET, DEVICE_ID, TYPE, TIMES)
values ('24449218628671', '离线', null, null, '0', to_timestamp('07-02-2014 15:20:18.536000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'Device4', '1', 1);
commit;
prompt 105 records loaded
prompt Loading JY_CABINET...
insert into JY_CABINET (CAB_ID, LINE_ID, ALARM_ID, CONSTANT_CABTYPE_ID, CONSTANT_POWERLEVEL_ID, ALARM_TYPE_COLLECT_ID, USER_GROUP_ID, CAB_NUMBER, SIM_NUMBER, SIM_S_NUMBER, TAG, STATUS, CREATE_TIME, DETECT_TIME, NOTE)
values ('Cab1', 'Line1', '24449218628671', 1, 7, '#00120140117090003', 1, '#001', null, null, 1, 1, to_timestamp('17-01-2014 09:00:03.631000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-02-2014 15:20:18.536000', 'dd-mm-yyyy hh24:mi:ss.ff'), null);
insert into JY_CABINET (CAB_ID, LINE_ID, ALARM_ID, CONSTANT_CABTYPE_ID, CONSTANT_POWERLEVEL_ID, ALARM_TYPE_COLLECT_ID, USER_GROUP_ID, CAB_NUMBER, SIM_NUMBER, SIM_S_NUMBER, TAG, STATUS, CREATE_TIME, DETECT_TIME, NOTE)
values ('Cab2', 'Line1', '22211157941941', 1, 7, '#00220140117090016', 1, '#002', null, null, 1, 1, to_timestamp('17-01-2014 09:00:16.735000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-02-2014 14:43:00.452000', 'dd-mm-yyyy hh24:mi:ss.ff'), null);
insert into JY_CABINET (CAB_ID, LINE_ID, ALARM_ID, CONSTANT_CABTYPE_ID, CONSTANT_POWERLEVEL_ID, ALARM_TYPE_COLLECT_ID, USER_GROUP_ID, CAB_NUMBER, SIM_NUMBER, SIM_S_NUMBER, TAG, STATUS, CREATE_TIME, DETECT_TIME, NOTE)
values ('Cab3', 'Line1', '26034460956600', 1, 7, '-1', 1, '#003', null, null, 1, 1, to_timestamp('21-01-2014 11:17:09.980000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('26-01-2014 15:41:41.857000', 'dd-mm-yyyy hh24:mi:ss.ff'), null);
commit;
prompt 3 records loaded
prompt Loading JY_DEVICE...
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device1', 'Cab2', '12998157709464', '001', '间隔1', null, null, 1, 1, to_timestamp('17-01-2014 09:00:31.010000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device2', 'Cab2', '1811729352533', '002', '间隔2', null, null, 1, 2, to_timestamp('17-01-2014 09:00:39.200000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device3', 'Cab2', '2436998728734', '003', '间隔3', null, null, 1, 3, to_timestamp('17-01-2014 09:00:48.232000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device4', 'Cab1', '25486042863651', '004', '间隔1', null, null, 1, 1, to_timestamp('17-01-2014 09:00:57.463000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device5', 'Cab1', '25486115595450', '005', '间隔2', null, null, 1, 2, to_timestamp('17-01-2014 09:01:05.325000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device6', 'Cab1', '26633108022445', '006', '间隔3', null, null, 1, 3, to_timestamp('17-01-2014 09:01:13.063000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device7', 'Cab3', '25673258717771', '011', '间隔1', null, null, 1, 1, to_timestamp('21-01-2014 11:17:32.519000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device8', 'Cab3', '25673323233900', '022', '间隔2', null, null, 1, 2, to_timestamp('21-01-2014 11:17:55.879000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into JY_DEVICE (DEVICE_ID, CAB_ID, ALARM_ID, DEVICE_NUMBER, NAME, STATUS, NOTE, TAG, POSITION_NUMBER, CREATE_TIME)
values ('Device9', 'Cab3', '25673388641116', '033', '间隔3', null, null, 1, 3, to_timestamp('21-01-2014 11:18:03.534000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 9 records loaded
prompt Loading JY_CONSTANT...
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (1, 'CabType', '1000', '环网柜', '10');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (2, 'CabType', '1001', '分段柜', '2');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (3, 'CabType', '1002', '高分箱', '3');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (4, 'CabType', '1003', '变电柜', '4');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (5, 'CabType', '1004', '配电', '5');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (6, 'CabType', '1005', '其他', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (7, 'PowerLevel', '1002', '10KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (8, 'PowerLevel', '1002', '0.4KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (9, 'PowerLevel', '1003', '35KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (10, 'PowerLevel', '1004', '66KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (11, 'PowerLevel', '1005', '110KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (12, 'PowerLevel', '1006', '220KV', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (13, 'PowerLevel', '1007', '其他', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (14, 'AlarmType', '1000', '报警温度超出设定值（T1℃）', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (15, 'AlarmType', '1001', '三相之间温差超出设定值（T2℃）', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (16, 'AlarmType', '1002', '三相与环境温差超出设定值（T3℃）', '6');
insert into JY_CONSTANT (ID, TYPE, KEY, VALUE, SUB_VALUE)
values (17, 'AlarmType', '1003', '特定间隔（T4m）时间内温度变化超过设定值（T5℃）', '6');
commit;
prompt 17 records loaded
prompt Loading JY_ALARM_TYPE...
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#001201401170900031000', 14, 75, 0, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#001201401170900031001', 15, 15, 1, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#001201401170900031002', 16, 15, 0, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#001201401170900031003', 17, 15, 1, 15);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#002201401170900161000', 14, 75, 0, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#002201401170900161001', 15, 15, 1, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#002201401170900161002', 16, 15, 0, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('#002201401170900161003', 17, 15, 1, 15);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('-11000', 14, 15, 1, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('-11001', 15, 25, 1, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('-11002', 16, 35, 1, null);
insert into JY_ALARM_TYPE (ID, ALARM_TYPE_ID, VALUE, ENABLE, SUBVALUE)
values ('-11003', 17, 10, 1, 15);
commit;
prompt 12 records loaded
prompt Loading JY_ALARM_TYPE_COLLECT...
insert into JY_ALARM_TYPE_COLLECT (ID, ALARM_TYPE1_ID, ALARM_TYPE2_ID, ALARM_TYPE3_ID, ALARM_TYPE4_ID)
values ('#00120140117090003', '#001201401170900031000', '#001201401170900031001', '#001201401170900031002', '#001201401170900031003');
insert into JY_ALARM_TYPE_COLLECT (ID, ALARM_TYPE1_ID, ALARM_TYPE2_ID, ALARM_TYPE3_ID, ALARM_TYPE4_ID)
values ('#00220140117090016', '#002201401170900161000', '#002201401170900161001', '#002201401170900161002', '#002201401170900161003');
insert into JY_ALARM_TYPE_COLLECT (ID, ALARM_TYPE1_ID, ALARM_TYPE2_ID, ALARM_TYPE3_ID, ALARM_TYPE4_ID)
values ('-1', '-11000', '-11001', '-11002', '-11003');
commit;
prompt 3 records loaded
prompt Loading JY_LINE...
insert into JY_LINE (LINE_ID, NAME, TAG)
values ('Line1', '线路1', 1);
commit;
prompt 1 records loaded
prompt Loading JY_USER_GROUP...
insert into JY_USER_GROUP (ID, GROUP_NAME, LEADER_NAME, NOTE)
values (1, '--', '--', null);
commit;
prompt 1 records loaded
prompt Loading JY_CABINET_HISTORY...
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('1770036197823', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('1811598353735', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('24088227866712', to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('24098885179326', to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('5324505963658', to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('5356637695587', to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('5408157576679', to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('2505402368239', to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('4687788012801', to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('4715563810030', to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('5407512457866', to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('11013621711286', to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab3');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('26633006302919', to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('27837067639138', to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('27855873052286', to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('27875123089657', to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('27881597967001', to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('20070623739923', to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('2436768227198', to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('2572747919078', to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('13104971915810', to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('25486000462722', to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('25621385625164', to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('25673215585054', to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab3');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('12181541409163', to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab3');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('8114630358875', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('8124847286397', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('8554436231188', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('8632242839325', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('9220570302428', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('9226373464820', to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('22489901636081', to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('26057735261320', to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('12998098418041', to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab2');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('22278632400495', to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
insert into JY_CABINET_HISTORY (ID, C_DATE, CAB_ID)
values ('23761992850777', to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Cab1');
commit;
prompt 36 records loaded
prompt Loading JY_DETECTOR...
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector1', 'Device1', 381, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector2', 'Device1', 382, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector3', 'Device1', 383, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector4', 'Device1', 384, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector5', 'Device2', 385, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector6', 'Device2', 386, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector7', 'Device2', 387, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector8', 'Device2', 388, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector9', 'Device3', 389, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector10', 'Device3', 390, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector11', 'Device3', 391, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector12', 'Device3', 392, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector13', 'Device4', 417, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector14', 'Device4', 418, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector15', 'Device4', 419, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector16', 'Device4', 420, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector17', 'Device5', 421, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector18', 'Device5', 422, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector19', 'Device5', 423, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector20', 'Device5', 424, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector21', 'Device6', 425, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector22', 'Device6', 426, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector23', 'Device6', 427, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector24', 'Device6', 428, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector25', 'Device7', 393, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector26', 'Device7', 394, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector27', 'Device7', 395, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector28', 'Device7', 396, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector29', 'Device8', 397, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector30', 'Device8', 398, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector31', 'Device8', 399, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector32', 'Device8', 400, '环境', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector33', 'Device9', 401, 'A相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector34', 'Device9', 402, 'B相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector35', 'Device9', 403, 'C相', '℃', 1);
insert into JY_DETECTOR (DETECTOR_ID, DEVICE_ID, HISTORY_ID, NAME, UNIT, TAG)
values ('Detector36', 'Device9', 404, '环境', '℃', 1);
commit;
prompt 36 records loaded
prompt Loading JY_HISTORY...
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (1, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '1770036197823', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (2, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '1770036197823', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (3, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '1770036197823', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (4, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '1770036197823', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (5, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '1770036197823', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (6, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '1770036197823', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (7, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '1770036197823', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (8, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '1770036197823', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (9, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '1770036197823', 135.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (10, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '1770036197823', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (11, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '1770036197823', 20.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (12, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '1770036197823', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (13, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '1811598353735', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (14, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '1811598353735', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (15, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '1811598353735', 24);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (16, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '1811598353735', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (17, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '1811598353735', 135.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (18, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '1811598353735', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (19, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '1811598353735', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (20, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '1811598353735', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (21, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '1811598353735', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (22, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '1811598353735', 1.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (23, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '1811598353735', .4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (24, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '1811598353735', 3.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (253, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '24088227866712', 223.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (254, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '24088227866712', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (255, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '24088227866712', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (256, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '24088227866712', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (257, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '24088227866712', 115.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (258, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '24088227866712', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (259, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '24088227866712', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (260, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '24088227866712', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (261, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '24088227866712', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (262, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '24088227866712', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (263, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '24088227866712', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (264, to_timestamp('24-01-2014 15:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '24088227866712', 110.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (265, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '24098885179326', 223.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (266, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '24098885179326', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (267, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '24098885179326', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (268, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '24098885179326', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (269, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '24098885179326', 115.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (270, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '24098885179326', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (271, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '24098885179326', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (272, to_timestamp('24-01-2014 15:13:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '24098885179326', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (25, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '5324505963658', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (26, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '5324505963658', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (27, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '5324505963658', 4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (28, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '5324505963658', .3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (29, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '5324505963658', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (30, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '5324505963658', 1.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (31, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '5324505963658', .4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (32, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '5324505963658', 3.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (33, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '5324505963658', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (34, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '5324505963658', 1.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (35, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '5324505963658', .4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (36, to_timestamp('17-01-2014 10:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '5324505963658', 3.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (37, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '5356637695587', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (38, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '5356637695587', 33.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (39, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '5356637695587', 34);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (40, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '5356637695587', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (41, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '5356637695587', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (42, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '5356637695587', 31.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (43, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '5356637695587', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (44, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '5356637695587', 33.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (45, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '5356637695587', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (46, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '5356637695587', 31.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (47, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '5356637695587', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (48, to_timestamp('17-01-2014 09:04:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '5356637695587', 33.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (49, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '5408157576679', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (50, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '5408157576679', 33.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (51, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '5408157576679', 34);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (52, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '5408157576679', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (53, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '5408157576679', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (54, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '5408157576679', 31.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (55, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '5408157576679', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (56, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '5408157576679', 33.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (57, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '5408157576679', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (58, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '5408157576679', 31.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (59, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '5408157576679', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (60, to_timestamp('17-01-2014 10:05:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '5408157576679', 33.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (85, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '2505402368239', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (86, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '2505402368239', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (87, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '2505402368239', 24);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (88, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '2505402368239', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (89, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '2505402368239', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (90, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '2505402368239', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (91, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '2505402368239', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (92, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '2505402368239', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (93, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '2505402368239', 15.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (94, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '2505402368239', 21.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (95, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '2505402368239', 20.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (96, to_timestamp('21-01-2014 09:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '2505402368239', 23.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (109, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '4687788012801', 63.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (110, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '4687788012801', 53.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (111, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '4687788012801', 44);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (112, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '4687788012801', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (113, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '4687788012801', 65.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (114, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '4687788012801', 51.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (115, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '4687788012801', 40.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (116, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '4687788012801', 43.2);
commit;
prompt 100 records committed...
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (117, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '4687788012801', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (118, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '4687788012801', 41.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (119, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '4687788012801', 50.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (120, to_timestamp('21-01-2014 09:49:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '4687788012801', 63.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (121, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '4715563810030', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (122, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '4715563810030', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (123, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '4715563810030', 14);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (124, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '4715563810030', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (125, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '4715563810030', 65.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (126, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '4715563810030', 51.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (127, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '4715563810030', 40.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (128, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '4715563810030', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (129, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '4715563810030', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (130, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '4715563810030', 41.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (131, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '4715563810030', 50.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (132, to_timestamp('21-01-2014 09:50:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '4715563810030', 63.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (133, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '5407512457866', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (134, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '5407512457866', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (135, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '5407512457866', 14);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (136, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '5407512457866', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (137, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '5407512457866', 65.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (138, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '5407512457866', 51.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (139, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '5407512457866', 40.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (140, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '5407512457866', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (141, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '5407512457866', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (142, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '5407512457866', 41.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (143, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '5407512457866', 50.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (144, to_timestamp('21-01-2014 10:01:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '5407512457866', 63.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (145, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector25', '11013621711286', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (146, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector26', '11013621711286', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (147, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector27', '11013621711286', 24);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (148, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector28', '11013621711286', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (149, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector29', '11013621711286', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (150, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector30', '11013621711286', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (151, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector31', '11013621711286', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (152, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector32', '11013621711286', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (153, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector33', '11013621711286', 15.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (154, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector34', '11013621711286', 21.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (155, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector35', '11013621711286', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (156, to_timestamp('21-01-2014 11:35:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector36', '11013621711286', 13.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (285, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '26633006302919', 223.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (286, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '26633006302919', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (287, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '26633006302919', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (288, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '26633006302919', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (289, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '26633006302919', null);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (290, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '26633006302919', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (291, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '26633006302919', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (292, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '26633006302919', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (293, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '26633006302919', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (294, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '26633006302919', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (295, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '26633006302919', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (296, to_timestamp('24-01-2014 15:55:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '26633006302919', 222.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (297, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '27837067639138', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (298, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '27837067639138', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (299, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '27837067639138', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (300, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '27837067639138', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (301, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '27837067639138', 0);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (302, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '27837067639138', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (303, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '27837067639138', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (304, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '27837067639138', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (305, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '27837067639138', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (306, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '27837067639138', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (307, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '27837067639138', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (308, to_timestamp('24-01-2014 16:15:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '27837067639138', 222.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (309, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '27855873052286', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (310, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '27855873052286', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (311, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '27855873052286', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (312, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '27855873052286', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (313, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '27855873052286', null);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (314, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '27855873052286', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (315, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '27855873052286', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (316, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '27855873052286', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (317, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '27855873052286', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (318, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '27855873052286', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (319, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '27855873052286', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (320, to_timestamp('24-01-2014 16:16:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '27855873052286', 222.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (321, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '27875123089657', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (322, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '27875123089657', .5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (323, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '27875123089657', 1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (324, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '27875123089657', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (325, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '27875123089657', null);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (326, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '27875123089657', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (327, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '27875123089657', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (328, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '27875123089657', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (329, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '27875123089657', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (330, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '27875123089657', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (331, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '27875123089657', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (332, to_timestamp('24-01-2014 16:16:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '27875123089657', 222.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (333, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '27881597967001', 3.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (334, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '27881597967001', .5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (335, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '27881597967001', 1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (336, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '27881597967001', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (337, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '27881597967001', 222.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (338, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '27881597967001', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (339, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '27881597967001', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (340, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '27881597967001', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (341, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '27881597967001', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (342, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '27881597967001', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (343, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '27881597967001', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (344, to_timestamp('24-01-2014 16:16:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '27881597967001', 222.2);
commit;
prompt 200 records committed...
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (61, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '20070623739923', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (62, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '20070623739923', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (63, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '20070623739923', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (64, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '20070623739923', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (65, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '20070623739923', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (66, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '20070623739923', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (67, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '20070623739923', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (68, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '20070623739923', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (69, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '20070623739923', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (70, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '20070623739923', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (71, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '20070623739923', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (72, to_timestamp('20-01-2014 14:13:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '20070623739923', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (73, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '2436768227198', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (74, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '2436768227198', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (75, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '2436768227198', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (76, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '2436768227198', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (77, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '2436768227198', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (78, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '2436768227198', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (79, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '2436768227198', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (80, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '2436768227198', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (81, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '2436768227198', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (82, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '2436768227198', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (83, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '2436768227198', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (84, to_timestamp('21-01-2014 01:11:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '2436768227198', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (97, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '2572747919078', 63.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (98, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '2572747919078', 53.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (99, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '2572747919078', 44);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (100, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '2572747919078', 30.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (101, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '2572747919078', 65.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (102, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '2572747919078', 51.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (103, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '2572747919078', 40.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (104, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '2572747919078', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (105, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '2572747919078', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (106, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '2572747919078', 41.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (107, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '2572747919078', 50.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (108, to_timestamp('21-01-2014 09:14:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '2572747919078', 63.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (357, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '13104971915810', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (358, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '13104971915810', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (359, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '13104971915810', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (360, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '13104971915810', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (361, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '13104971915810', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (362, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '13104971915810', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (363, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '13104971915810', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (364, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '13104971915810', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (365, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '13104971915810', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (366, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '13104971915810', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (367, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '13104971915810', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (368, to_timestamp('26-01-2014 12:06:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '13104971915810', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (369, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '25486000462722', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (370, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '25486000462722', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (371, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '25486000462722', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (372, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '25486000462722', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (373, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '25486000462722', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (374, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '25486000462722', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (375, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '25486000462722', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (376, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '25486000462722', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (377, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '25486000462722', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (378, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '25486000462722', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (379, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '25486000462722', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (380, to_timestamp('26-01-2014 15:32:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '25486000462722', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (381, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '25621385625164', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (382, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '25621385625164', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (383, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '25621385625164', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (384, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '25621385625164', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (385, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '25621385625164', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (386, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '25621385625164', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (387, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '25621385625164', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (388, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '25621385625164', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (389, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '25621385625164', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (390, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '25621385625164', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (391, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '25621385625164', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (392, to_timestamp('26-01-2014 15:34:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '25621385625164', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (393, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector25', '25673215585054', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (394, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector26', '25673215585054', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (395, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector27', '25673215585054', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (396, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector28', '25673215585054', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (397, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector29', '25673215585054', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (398, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector30', '25673215585054', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (399, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector31', '25673215585054', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (400, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector32', '25673215585054', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (401, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector33', '25673215585054', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (402, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector34', '25673215585054', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (403, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector35', '25673215585054', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (404, to_timestamp('26-01-2014 15:35:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector36', '25673215585054', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (157, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector25', '12181541409163', 23.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (158, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector26', '12181541409163', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (159, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector27', '12181541409163', 24);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (160, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector28', '12181541409163', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (161, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector29', '12181541409163', 35.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (162, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector30', '12181541409163', 11.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (163, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector31', '12181541409163', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (164, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector32', '12181541409163', 43.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (165, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector33', '12181541409163', 15.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (166, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector34', '12181541409163', 21.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (167, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector35', '12181541409163', 30.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (168, to_timestamp('21-01-2014 11:54:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector36', '12181541409163', 13.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (169, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '8114630358875', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (170, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '8114630358875', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (171, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '8114630358875', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (172, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '8114630358875', 10.3);
commit;
prompt 300 records committed...
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (173, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '8114630358875', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (174, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '8114630358875', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (175, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '8114630358875', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (176, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '8114630358875', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (177, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '8114630358875', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (178, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '8114630358875', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (179, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '8114630358875', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (180, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '8114630358875', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (181, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '8124847286397', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (182, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '8124847286397', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (183, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '8124847286397', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (184, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '8124847286397', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (185, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '8124847286397', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (186, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '8124847286397', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (187, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '8124847286397', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (188, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '8124847286397', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (189, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '8124847286397', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (190, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '8124847286397', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (191, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '8124847286397', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (192, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '8124847286397', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (193, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '8554436231188', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (194, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '8554436231188', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (195, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '8554436231188', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (196, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '8554436231188', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (197, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '8554436231188', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (198, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '8554436231188', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (199, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '8554436231188', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (200, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '8554436231188', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (201, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '8554436231188', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (202, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '8554436231188', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (203, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '8554436231188', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (204, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '8554436231188', 103.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (205, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '8632242839325', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (206, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '8632242839325', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (207, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '8632242839325', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (208, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '8632242839325', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (209, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '8632242839325', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (210, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '8632242839325', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (211, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '8632242839325', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (212, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '8632242839325', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (213, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '8632242839325', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (214, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '8632242839325', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (215, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '8632242839325', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (216, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '8632242839325', 103.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (217, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '9220570302428', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (218, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '9220570302428', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (219, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '9220570302428', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (220, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '9220570302428', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (221, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '9220570302428', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (222, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '9220570302428', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (223, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '9220570302428', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (224, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '9220570302428', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (225, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '9220570302428', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (226, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '9220570302428', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (227, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '9220570302428', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (228, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '9220570302428', 103.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (229, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '9226373464820', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (230, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '9226373464820', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (231, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '9226373464820', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (232, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '9226373464820', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (233, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '9226373464820', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (234, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '9226373464820', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (235, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '9226373464820', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (236, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '9226373464820', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (237, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '9226373464820', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (238, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '9226373464820', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (239, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '9226373464820', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (240, to_timestamp('24-01-2014 10:46:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '9226373464820', 103.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (241, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '22489901636081', 223.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (242, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '22489901636081', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (243, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '22489901636081', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (244, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '22489901636081', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (245, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '22489901636081', 115.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (246, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '22489901636081', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (247, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '22489901636081', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (248, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '22489901636081', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (249, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '22489901636081', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (250, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '22489901636081', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (251, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '22489901636081', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (252, to_timestamp('24-01-2014 14:46:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '22489901636081', 100.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (273, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '26057735261320', 223.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (274, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '26057735261320', 11.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (275, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '26057735261320', 121);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (276, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '26057735261320', 11.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (277, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '26057735261320', 115.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (278, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '26057735261320', 111);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (279, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '26057735261320', 10.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (280, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '26057735261320', 141.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (281, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '26057735261320', 5.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (282, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '26057735261320', 110.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (283, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '26057735261320', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (284, to_timestamp('24-01-2014 15:46:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '26057735261320', null);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (345, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', '12998098418041', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (346, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', '12998098418041', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (347, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', '12998098418041', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (348, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', '12998098418041', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (349, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', '12998098418041', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (350, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', '12998098418041', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (351, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', '12998098418041', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (352, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', '12998098418041', 143.2);
commit;
prompt 400 records committed...
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (353, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', '12998098418041', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (354, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', '12998098418041', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (355, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', '12998098418041', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (356, to_timestamp('26-01-2014 12:04:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', '12998098418041', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (405, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '22278632400495', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (406, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '22278632400495', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (407, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '22278632400495', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (408, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '22278632400495', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (409, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '22278632400495', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (410, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '22278632400495', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (411, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '22278632400495', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (412, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '22278632400495', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (413, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '22278632400495', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (414, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '22278632400495', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (415, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '22278632400495', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (416, to_timestamp('07-02-2014 14:44:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '22278632400495', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (417, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', '23761992850777', 123.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (418, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', '23761992850777', 13.5);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (419, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', '23761992850777', 124);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (420, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', '23761992850777', 10.3);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (421, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', '23761992850777', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (422, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', '23761992850777', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (423, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', '23761992850777', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (424, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', '23761992850777', 143.2);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (425, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', '23761992850777', 235.6);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (426, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', '23761992850777', 111.1);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (427, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', '23761992850777', 10.4);
insert into JY_HISTORY (ID, C_DATE, DETECTOR_ID, CABINETHISTORY_ID, VALUE)
values (428, to_timestamp('07-02-2014 15:08:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', '23761992850777', 143.2);
commit;
prompt 428 records loaded
prompt Loading JY_HISTORY_CHART...
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (25, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (26, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (27, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 24);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (28, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (29, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 135.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (30, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (31, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (32, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (33, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (34, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (35, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (36, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (37, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (38, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (39, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (40, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (41, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (42, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (43, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (44, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (45, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 135.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (46, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (47, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 20.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (48, to_timestamp('17-01-2014 10:00:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (145, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (146, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 33.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (147, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 34);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (148, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (149, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (150, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (151, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (152, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (153, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (154, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (155, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (156, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (157, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (158, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (159, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (160, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', .3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (161, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (162, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (163, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (164, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (165, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (166, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (167, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (168, to_timestamp('17-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (289, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (290, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', .5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (291, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (292, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 11.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (293, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 222.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (294, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (295, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (296, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 141.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (297, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (298, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 110.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (299, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (300, to_timestamp('24-01-2014 17:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 222.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (1, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (2, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (3, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 24);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (4, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (5, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 135.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (6, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (7, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (8, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (9, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (10, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (11, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (12, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (13, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (14, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (15, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (16, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (17, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (18, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (19, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (20, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (21, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 135.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (22, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (23, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 20.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (24, to_timestamp('17-01-2014 09:30:00.027000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (73, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (74, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 33.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (75, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 34);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (76, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (77, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (78, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (79, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (80, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (81, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (82, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (83, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (84, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (85, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (86, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (87, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (88, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', .3);
commit;
prompt 100 records committed...
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (89, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (90, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (91, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (92, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (93, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (94, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (95, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (96, to_timestamp('17-01-2014 11:00:00.045000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (97, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (98, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 33.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (99, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 34);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (100, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (101, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (102, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (103, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (104, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (105, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (106, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (107, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (108, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (109, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (110, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (111, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (112, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', .3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (113, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (114, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (115, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (116, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (117, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (118, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (119, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (120, to_timestamp('17-01-2014 11:30:00.046000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (169, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (170, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (171, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (172, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (173, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (174, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (175, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (176, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (177, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (178, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (179, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (180, to_timestamp('20-01-2014 15:00:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (181, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (182, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (183, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (184, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (185, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (186, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (187, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (188, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (189, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (190, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (191, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (192, to_timestamp('20-01-2014 15:30:00.001000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (205, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (206, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (207, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (208, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (209, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (210, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (211, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (212, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (213, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (214, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (215, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (216, to_timestamp('20-01-2014 16:30:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (217, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (218, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (219, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (220, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (221, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (222, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (223, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (224, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (225, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (226, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (227, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (228, to_timestamp('20-01-2014 17:00:00.004000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (241, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (242, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (243, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 14);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (244, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (245, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 65.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (246, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 51.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (247, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 40.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (248, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (249, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (250, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 41.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (251, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 50.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (252, to_timestamp('21-01-2014 11:30:00.002000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 63.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (253, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (254, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (255, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 14);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (256, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (257, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 65.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (258, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 51.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (259, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 40.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (260, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 43.2);
commit;
prompt 200 records committed...
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (261, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (262, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 41.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (263, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 50.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (264, to_timestamp('21-01-2014 12:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 63.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (277, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 223.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (278, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 11.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (279, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 121);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (280, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 11.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (281, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', null);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (282, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (283, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (284, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 141.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (285, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (286, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 110.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (287, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (288, to_timestamp('24-01-2014 16:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 222.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (49, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (50, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 33.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (51, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 34);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (52, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (53, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (54, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (55, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (56, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (57, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (58, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (59, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (60, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (61, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (62, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (63, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (64, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', .3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (65, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (66, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (67, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (68, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (69, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (70, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (71, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (72, to_timestamp('17-01-2014 10:30:00.030000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (121, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 23.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (122, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 33.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (123, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 34);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (124, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (125, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (126, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (127, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (128, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (129, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (130, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 31.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (131, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 30.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (132, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 33.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (133, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (134, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 3.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (135, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (136, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', .3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (137, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (138, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (139, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (140, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (141, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 5.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (142, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 1.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (143, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', .4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (144, to_timestamp('17-01-2014 12:00:00.013000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 3.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (193, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (194, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (195, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (196, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (197, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (198, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (199, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (200, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (201, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (202, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 11.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (203, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (204, to_timestamp('20-01-2014 16:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (229, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector1', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (230, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector2', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (231, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector3', 14);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (232, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector4', 30.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (233, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector5', 65.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (234, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector6', 51.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (235, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector7', 40.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (236, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector8', 43.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (237, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector9', 35.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (238, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector10', 41.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (239, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector11', 50.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (240, to_timestamp('21-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector12', 63.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (265, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector13', 123.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (266, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector14', 13.5);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (267, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector15', 124);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (268, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector16', 10.3);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (269, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector17', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (270, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector18', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (271, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector19', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (272, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector20', 143.2);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (273, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector21', 235.6);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (274, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector22', 111.1);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (275, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector23', 10.4);
insert into JY_HISTORY_CHART (ID, C_DATE, DETECTOR_ID, VALUE)
values (276, to_timestamp('24-01-2014 11:00:00.003000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'Detector24', 103.2);
commit;
prompt 300 records loaded
prompt Loading JY_HISTORY_MONTH_CHART...
prompt Table is empty
prompt Loading JY_KEY_GENERATOR...
insert into JY_KEY_GENERATOR (ID, USER_ID, LINE_ID, DEVICE_ID, DETECTOR_ID, CAB_ID)
values (1, 3, 2, 10, 37, 4);
commit;
prompt 1 records loaded
prompt Loading JY_USER...
insert into JY_USER (USER_ID, ISFIRSTLOGIN, USERNAME, PASSWORD, CONTACT, COMPANY, JOB_LEVEL, USER_LEVEL, CAN_RECMES, GROUP_ID)
values ('YH1', 0, 'admin', '21232f297a57a5a743894a0e4a801fc3', null, null, null, 'super_admin', null, null);
insert into JY_USER (USER_ID, ISFIRSTLOGIN, USERNAME, PASSWORD, CONTACT, COMPANY, JOB_LEVEL, USER_LEVEL, CAN_RECMES, GROUP_ID)
values ('YH2', 1, '--', '9dc5f758e8e773980f07a95bfc8642f1', null, null, null, 'com_admin', null, 1);
commit;
prompt 2 records loaded
prompt Enabling foreign key constraints for JY_ALARM...
alter table JY_ALARM enable constraint FK11047F41807F4191;
prompt Enabling foreign key constraints for JY_CABINET...
alter table JY_CABINET enable constraint FK38F2EB484CDFBDA3;
alter table JY_CABINET enable constraint FK38F2EB485F790DD;
alter table JY_CABINET enable constraint FK38F2EB48A286E91;
alter table JY_CABINET enable constraint FK38F2EB48A2C603DB;
alter table JY_CABINET enable constraint FK38F2EB48AF055F4C;
alter table JY_CABINET enable constraint FK38F2EB48D53330F2;
prompt Enabling foreign key constraints for JY_DEVICE...
alter table JY_DEVICE enable constraint FK4AEBCB464CDFBDA3;
alter table JY_DEVICE enable constraint FK4AEBCB46D2758917;
prompt Enabling foreign key constraints for JY_ALARM_TYPE...
alter table JY_ALARM_TYPE enable constraint FK1D4F2978A288F1CD;
prompt Enabling foreign key constraints for JY_ALARM_TYPE_COLLECT...
alter table JY_ALARM_TYPE_COLLECT enable constraint FK995139639C859685;
alter table JY_ALARM_TYPE_COLLECT enable constraint FK995139639C860AE4;
alter table JY_ALARM_TYPE_COLLECT enable constraint FK995139639C867F43;
alter table JY_ALARM_TYPE_COLLECT enable constraint FK995139639C86F3A2;
prompt Enabling foreign key constraints for JY_CABINET_HISTORY...
alter table JY_CABINET_HISTORY enable constraint FK52CBFABDD2758917;
prompt Enabling foreign key constraints for JY_DETECTOR...
alter table JY_DETECTOR enable constraint FK3B8448B6807F4191;
alter table JY_DETECTOR enable constraint FK3B8448B6AF65B483;
prompt Enabling foreign key constraints for JY_HISTORY...
alter table JY_HISTORY enable constraint FKFE90D9A4AC8401D1;
alter table JY_HISTORY enable constraint FKFE90D9A4D40CE0B1;
prompt Enabling foreign key constraints for JY_HISTORY_CHART...
alter table JY_HISTORY_CHART enable constraint FK86084983AC8401D1;
prompt Enabling foreign key constraints for JY_HISTORY_MONTH_CHART...
alter table JY_HISTORY_MONTH_CHART enable constraint FK9BE05F44AC8401D1;
prompt Enabling foreign key constraints for JY_USER...
alter table JY_USER enable constraint FKBB4090BBAC020558;
prompt Enabling triggers for JY_ALARM...
alter table JY_ALARM enable all triggers;
prompt Enabling triggers for JY_CABINET...
alter table JY_CABINET enable all triggers;
prompt Enabling triggers for JY_DEVICE...
alter table JY_DEVICE enable all triggers;
prompt Enabling triggers for JY_CONSTANT...
alter table JY_CONSTANT enable all triggers;
prompt Enabling triggers for JY_ALARM_TYPE...
alter table JY_ALARM_TYPE enable all triggers;
prompt Enabling triggers for JY_ALARM_TYPE_COLLECT...
alter table JY_ALARM_TYPE_COLLECT enable all triggers;
prompt Enabling triggers for JY_LINE...
alter table JY_LINE enable all triggers;
prompt Enabling triggers for JY_USER_GROUP...
alter table JY_USER_GROUP enable all triggers;
prompt Enabling triggers for JY_CABINET_HISTORY...
alter table JY_CABINET_HISTORY enable all triggers;
prompt Enabling triggers for JY_DETECTOR...
alter table JY_DETECTOR enable all triggers;
prompt Enabling triggers for JY_HISTORY...
alter table JY_HISTORY enable all triggers;
prompt Enabling triggers for JY_HISTORY_CHART...
alter table JY_HISTORY_CHART enable all triggers;
prompt Enabling triggers for JY_HISTORY_MONTH_CHART...
alter table JY_HISTORY_MONTH_CHART enable all triggers;
prompt Enabling triggers for JY_KEY_GENERATOR...
alter table JY_KEY_GENERATOR enable all triggers;
prompt Enabling triggers for JY_USER...
alter table JY_USER enable all triggers;
set feedback on
set define on
prompt Done.
