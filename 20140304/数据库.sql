prompt PL/SQL Developer import file
prompt Created on 2014��3��24�� by Administrator
set feedback off
set define off
prompt Disabling triggers for BBG...
alter table BBG disable all triggers;
prompt Disabling triggers for BBGSHTHJL...
alter table BBGSHTHJL disable all triggers;
prompt Disabling triggers for BXMJBXX...
alter table BXMJBXX disable all triggers;
prompt Disabling triggers for BCGJH...
alter table BCGJH disable all triggers;
prompt Disabling triggers for BHTXX...
alter table BHTXX disable all triggers;
prompt Disabling triggers for BHKJH...
alter table BHKJH disable all triggers;
prompt Disabling triggers for BJDJH...
alter table BJDJH disable all triggers;
prompt Disabling triggers for BKPJH...
alter table BKPJH disable all triggers;
prompt Disabling triggers for BLSXMCB...
alter table BLSXMCB disable all triggers;
prompt Disabling triggers for BLWWBCGJH...
alter table BLWWBCGJH disable all triggers;
prompt Disabling triggers for BRY...
alter table BRY disable all triggers;
prompt Disabling triggers for BZDBB...
alter table BZDBB disable all triggers;
prompt Disabling triggers for HCGJH...
alter table HCGJH disable all triggers;
prompt Disabling triggers for HHKJH...
alter table HHKJH disable all triggers;
prompt Disabling triggers for HHTXX...
alter table HHTXX disable all triggers;
prompt Disabling triggers for HJDJH...
alter table HJDJH disable all triggers;
prompt Disabling triggers for HKPJH...
alter table HKPJH disable all triggers;
prompt Disabling triggers for HXMJBXX...
alter table HXMJBXX disable all triggers;
prompt Disabling triggers for PMISUSER...
alter table PMISUSER disable all triggers;
prompt Disabling triggers for SBGX...
alter table SBGX disable all triggers;
prompt Disabling triggers for SBM...
alter table SBM disable all triggers;
prompt Disabling triggers for SCD...
alter table SCD disable all triggers;
prompt Disabling triggers for SJS...
alter table SJS disable all triggers;
prompt Disabling triggers for SCD_JS...
alter table SCD_JS disable all triggers;
prompt Disabling triggers for SDMK...
alter table SDMK disable all triggers;
prompt Disabling triggers for SFILTER...
alter table SFILTER disable all triggers;
prompt Disabling triggers for SGW...
alter table SGW disable all triggers;
prompt Disabling triggers for SJDJD...
alter table SJDJD disable all triggers;
prompt Disabling triggers for SKHXX...
alter table SKHXX disable all triggers;
prompt Disabling triggers for SWBDW...
alter table SWBDW disable all triggers;
prompt Disabling triggers for SXTYH...
alter table SXTYH disable all triggers;
prompt Disabling triggers for SXTYH_JS...
alter table SXTYH_JS disable all triggers;
prompt Disabling triggers for SYJFK...
alter table SYJFK disable all triggers;
prompt Disabling triggers for SZCPX...
alter table SZCPX disable all triggers;
prompt Disabling foreign key constraints for BCGJH...
alter table BCGJH disable constraint FK_BCGJH_FK_CGYQ_H_BXMJBXX;
prompt Disabling foreign key constraints for BHTXX...
alter table BHTXX disable constraint FK_BHTXX_FK_HTXX_X_BXMJBXX;
prompt Disabling foreign key constraints for BHKJH...
alter table BHKJH disable constraint FK_BHKJH_FK_HKJH_H_BHTXX;
alter table BHKJH disable constraint FK_BHKJH_FK_HKYQ_H_BXMJBXX;
prompt Disabling foreign key constraints for BJDJH...
alter table BJDJH disable constraint FK_BJDJH_FK_JDYQ_H_BXMJBXX;
prompt Disabling foreign key constraints for BKPJH...
alter table BKPJH disable constraint FK_BKPJH_FK_KPJH_H_BHTXX;
alter table BKPJH disable constraint FK_BKPJH_FK_KPYQ_H_BXMJBXX;
prompt Disabling foreign key constraints for BLWWBCGJH...
alter table BLWWBCGJH disable constraint FK_BLWWBCGJ_REFERENCE_BXMJBXX;
prompt Disabling foreign key constraints for SCD_JS...
alter table SCD_JS disable constraint FK_SCD_JS_FK_CDJS_J_SJS;
alter table SCD_JS disable constraint FK_SCD_JS_FK_YHJS_J_SCD;
prompt Disabling foreign key constraints for SXTYH...
alter table SXTYH disable constraint FK_SXTYH_FK_YH_BMI_SBM;
alter table SXTYH disable constraint FK_SXTYH_FK_YH_WBD_SWBDW;
prompt Disabling foreign key constraints for SXTYH_JS...
alter table SXTYH_JS disable constraint FK_SXTYH_JS_FK_YHJS_J_SJS;
alter table SXTYH_JS disable constraint FK_SXTYH_JS_FK_YHJS_Y_SXTYH;
prompt Deleting SZCPX...
delete from SZCPX;
commit;
prompt Deleting SYJFK...
delete from SYJFK;
commit;
prompt Deleting SXTYH_JS...
delete from SXTYH_JS;
commit;
prompt Deleting SXTYH...
delete from SXTYH;
commit;
prompt Deleting SWBDW...
delete from SWBDW;
commit;
prompt Deleting SKHXX...
delete from SKHXX;
commit;
prompt Deleting SJDJD...
delete from SJDJD;
commit;
prompt Deleting SGW...
delete from SGW;
commit;
prompt Deleting SFILTER...
delete from SFILTER;
commit;
prompt Deleting SDMK...
delete from SDMK;
commit;
prompt Deleting SCD_JS...
delete from SCD_JS;
commit;
prompt Deleting SJS...
delete from SJS;
commit;
prompt Deleting SCD...
delete from SCD;
commit;
prompt Deleting SBM...
delete from SBM;
commit;
prompt Deleting SBGX...
delete from SBGX;
commit;
prompt Deleting PMISUSER...
delete from PMISUSER;
commit;
prompt Deleting HXMJBXX...
delete from HXMJBXX;
commit;
prompt Deleting HKPJH...
delete from HKPJH;
commit;
prompt Deleting HJDJH...
delete from HJDJH;
commit;
prompt Deleting HHTXX...
delete from HHTXX;
commit;
prompt Deleting HHKJH...
delete from HHKJH;
commit;
prompt Deleting HCGJH...
delete from HCGJH;
commit;
prompt Deleting BZDBB...
delete from BZDBB;
commit;
prompt Deleting BRY...
delete from BRY;
commit;
prompt Deleting BLWWBCGJH...
delete from BLWWBCGJH;
commit;
prompt Deleting BLSXMCB...
delete from BLSXMCB;
commit;
prompt Deleting BKPJH...
delete from BKPJH;
commit;
prompt Deleting BJDJH...
delete from BJDJH;
commit;
prompt Deleting BHKJH...
delete from BHKJH;
commit;
prompt Deleting BHTXX...
delete from BHTXX;
commit;
prompt Deleting BCGJH...
delete from BCGJH;
commit;
prompt Deleting BXMJBXX...
delete from BXMJBXX;
commit;
prompt Deleting BBGSHTHJL...
delete from BBGSHTHJL;
commit;
prompt Deleting BBG...
delete from BBG;
commit;
prompt Loading BBG...
insert into BBG (BGID, BGLX, XMID, GZRQ, GZXS, GZDD, GZNR, BGR, BGSJ, ZT, SHR, SHSJ, SHXX, CZXTH, SJBZM)
values ('20140324143631635001', '0003', '-1', to_date('24-03-2014', 'dd-mm-yyyy'), 8, 'tyu', 'dfrty', '20140227115137078017', to_timestamp('24-03-2014 14:36:31.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', null, null, null, 'czxth0001', 'sjbzm0001');
insert into BBG (BGID, BGLX, XMID, GZRQ, GZXS, GZDD, GZNR, BGR, BGSJ, ZT, SHR, SHSJ, SHXX, CZXTH, SJBZM)
values ('20140324143655100002', '0003', '-1', to_date('24-03-2014', 'dd-mm-yyyy'), 8, 'tyu', 'dftyui', '20140227115137078017', to_timestamp('24-03-2014 14:36:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', null, null, null, 'czxth0001', 'sjbzm0001');
insert into BBG (BGID, BGLX, XMID, GZRQ, GZXS, GZDD, GZNR, BGR, BGSJ, ZT, SHR, SHSJ, SHXX, CZXTH, SJBZM)
values ('20140324143739376003', '0003', '-1', to_date('24-03-2014', 'dd-mm-yyyy'), 8, 'tyu', 'dfgh', '20140227115137078017', to_timestamp('24-03-2014 14:37:39.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0', null, null, null, 'czxth0001', 'sjbzm0001');
commit;
prompt 3 records loaded
prompt Loading BBGSHTHJL...
prompt Table is empty
prompt Loading BXMJBXX...
insert into BXMJBXX (XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS)
values ('20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113319687007', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '57', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����');
insert into BXMJBXX (XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS)
values ('20140227141147015050', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ�������ά', '0006', '20140227113319687007', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '5', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά');
insert into BXMJBXX (XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS)
values ('20140227141229531052', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ���ά', '0006', '20140227113319687007', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '5', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά');
commit;
prompt 3 records loaded
prompt Loading BCGJH...
insert into BCGJH (CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ)
values ('20140227162103156089', '20140227141121765048', '�ʼǱ�����', 'EM6400', '̨', '˫��1g�ڴ�', '3��ԭ��ά�������˵渶ȫ���30%', 1, .8, to_date('07-03-2014', 'dd-mm-yyyy'));
insert into BCGJH (CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ)
values ('20140227162514593091', '20140227141121765048', '����ϵͳ', 'win7', '��', '��ҵ�������lisence', 'ά����Ա���Ű�װ�������úð�ȫ��Ϣ', 1, 1.2, to_date('06-03-2014', 'dd-mm-yyyy'));
insert into BCGJH (CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ)
values ('20140228110320203019', '20140227141121765048', '����', '8U', '��', '��ɫ����������', '�ṩһ��ά��', 1, .5, to_date('15-02-2014', 'dd-mm-yyyy'));
commit;
prompt 3 records loaded
prompt Loading BHTXX...
insert into BHTXX (HTID, XMID, HTMC, HTBH, HTQDSJ, HTE, ERPXMBH, HTLYJFSJ, HTLYJSSJ, KHMC, XSDDH, HTZT, SL, XSJL)
values ('20140227143136859054', '20140227141121765048', '�����ͷ�������Ϣϵͳ��ά', '2014-01-01-yw001', to_date('01-01-2014', 'dd-mm-yyyy'), 48, 'B34635140007', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), '1', '500192876', 'YQD', 6, null);
insert into BHTXX (HTID, XMID, HTMC, HTBH, HTQDSJ, HTE, ERPXMBH, HTLYJFSJ, HTLYJSSJ, KHMC, XSDDH, HTZT, SL, XSJL)
values ('20140228103510578010', '20140227141121765048', '��ͬ1', 'HT1223', null, 100, 'ERP123', null, null, '28', 'SX111', 'WQD', 6, null);
commit;
prompt 2 records loaded
prompt Loading BHKJH...
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140227143852468065', '20140227141121765048', '20140227143136859054', '��ͬ50%��Լ�ؿ�', '����', to_date('01-07-2014', 'dd-mm-yyyy'), 60, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140227143852531067', '20140227141121765048', '20140227143136859054', '��ͬ������Լ�ؿ�', '����', to_date('01-09-2014', 'dd-mm-yyyy'), 30, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140227143852531069', '20140227141121765048', '20140227143136859054', '��ͬ������Լ�ؿ�', '�ͻ�ǩ����Լ����', to_date('31-12-2014', 'dd-mm-yyyy'), 10, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140227143852546071', '20140227141121765048', '20140227143136859054', null, null, null, 0, '0');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140227143852546073', '20140227141121765048', '20140227143136859054', null, null, null, 0, '0');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140228111815609030', '20140227141121765048', '20140228103510578010', '����׶�', '�ͻ�ǩ��������', to_date('28-02-2014', 'dd-mm-yyyy'), 30, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140228111815640032', '20140227141121765048', '20140228103510578010', '������Լ', '��Լ�������', to_date('01-11-2014', 'dd-mm-yyyy'), 60, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140228111815656034', '20140227141121765048', '20140228103510578010', '����', '��Ŀ���ձ���', to_date('31-12-2014', 'dd-mm-yyyy'), 10, '1');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140228111815656036', '20140227141121765048', '20140228103510578010', null, null, null, 0, '0');
insert into BHKJH (HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT)
values ('20140228111815656038', '20140227141121765048', '20140228103510578010', null, null, null, 0, '0');
commit;
prompt 10 records loaded
prompt Loading BJDJH...
insert into BJDJH (JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ)
values ('20140227144046000085', '20140227141121765048', '21', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('28-02-2014', 'dd-mm-yyyy'), null, null, '��Ŀ��������Դ������');
insert into BJDJH (JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ)
values ('20140228103810187013', '20140227141121765048', '����׶�', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-01-2014', 'dd-mm-yyyy'), null, null, 'Ϊ��ά��Ŀ����볡׼����' || chr(13) || '' || chr(10) || '�ͻ�ǩ���볡����');
insert into BJDJH (JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ)
values ('20140228103902000015', '20140227141121765048', '����ʵʩ', to_date('01-02-2014', 'dd-mm-yyyy'), to_date('31-10-2014', 'dd-mm-yyyy'), null, null, '�Ժ�ͬ�ķ��������Լʵʩ��' || chr(13) || '' || chr(10) || 'ÿ���µķ��񱨸�');
insert into BJDJH (JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ)
values ('20140228103945250017', '20140227141121765048', '���ս׶�', to_date('01-10-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '������չ�����' || chr(13) || '' || chr(10) || '�ͻ�ǩ�����յ���');
commit;
prompt 4 records loaded
prompt Loading BKPJH...
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140227143657968057', '20140227141121765048', '20140227143136859054', '0002', 60, to_date('01-07-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140227143658031059', '20140227141121765048', '20140227143136859054', '0002', 30, to_date('01-09-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140227143658046061', '20140227141121765048', '20140227143136859054', '0002', 10, to_date('31-12-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140227143658046063', '20140227141121765048', '20140227143136859054', '0002', 0, null, '0');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140228111534484022', '20140227141121765048', '20140228103510578010', '0001', 60, to_date('01-06-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140228111534515024', '20140227141121765048', '20140228103510578010', '0001', 30, to_date('01-11-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140228111534515026', '20140227141121765048', '20140228103510578010', '0001', 10, to_date('31-12-2014', 'dd-mm-yyyy'), '1');
insert into BKPJH (KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT)
values ('20140228111534515028', '20140227141121765048', '20140228103510578010', '0001', 0, null, '0');
commit;
prompt 8 records loaded
prompt Loading BLSXMCB...
prompt Table is empty
prompt Loading BLWWBCGJH...
insert into BLWWBCGJH (LWWBCGJHID, XMID, YHID, GW, GWJB, FL, GZL, XQSL, KSSJ, JSSJ, JNYQ, BZ)
values ('20140227163848000093', '20140227141121765048', '-1', '0020', '0003', 1500, 20, null, to_date('01-02-2014', 'dd-mm-yyyy'), to_date('20-02-2014', 'dd-mm-yyyy'), '�ܹ����', '�Ը�����Ϊ�˳�ʵ');
insert into BLWWBCGJH (LWWBCGJHID, XMID, YHID, GW, GWJB, FL, GZL, XQSL, KSSJ, JSSJ, JNYQ, BZ)
values ('20140227164156468095', '20140227141121765048', '-1', '0008', '0002', 2000, 20, null, to_date('01-02-2014', 'dd-mm-yyyy'), to_date('20-02-2014', 'dd-mm-yyyy'), null, null);
insert into BLWWBCGJH (LWWBCGJHID, XMID, YHID, GW, GWJB, FL, GZL, XQSL, KSSJ, JSSJ, JNYQ, BZ)
values ('20140227174401031100', '20140227141229531052', '-1', '0002', '0003', 123, 123, null, to_date('13-02-2014', 'dd-mm-yyyy'), to_date('28-02-2014', 'dd-mm-yyyy'), null, null);
insert into BLWWBCGJH (LWWBCGJHID, XMID, YHID, GW, GWJB, FL, GZL, XQSL, KSSJ, JSSJ, JNYQ, BZ)
values ('20140228111038062021', '20140227141121765048', '-1', '0008', '0003', 2000, 100, null, to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), 'ITIL����������', '���깤�����飬211��ѧ��ҵ��');
insert into BLWWBCGJH (LWWBCGJHID, XMID, YHID, GW, GWJB, FL, GZL, XQSL, KSSJ, JSSJ, JNYQ, BZ)
values ('20140228114150031041', '20140227141229531052', '20140228114002500040', '0003', '0002', 0, 20, 1, to_date('01-02-2014', 'dd-mm-yyyy'), to_date('20-02-2014', 'dd-mm-yyyy'), null, null);
commit;
prompt 5 records loaded
prompt Loading BRY...
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130522375021', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130455515019', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130508390020', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130809125022', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130824468023', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140227130834828024', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20140228114002500040', null, '0003', 0, '0002');
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('3', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('4', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('5', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('6', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('1', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('2', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('7', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('8', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('9', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('10', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('11', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('12', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('13', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('14', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('15', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('16', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('17', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('18', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('19', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('20', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('21', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('22', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('23', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('24', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('25', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('26', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('27', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('28', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('29', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('30', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('31', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('32', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('33', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('34', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('35', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('36', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('37', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('38', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('39', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('40', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('41', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('42', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('43', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('44', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('45', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('46', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('47', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('48', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('49', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('50', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('51', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('52', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('53', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('54', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('55', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('56', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('57', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('58', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('59', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('60', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('61', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('62', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('63', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('64', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('65', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('66', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('67', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('68', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('69', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('70', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('71', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('72', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('73', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('74', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('75', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('76', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('77', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('78', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('79', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('80', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('81', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('82', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('83', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('84', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('85', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('86', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('87', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('88', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('89', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('90', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('91', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('92', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('93', null, null, null, null);
commit;
prompt 100 records committed...
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('94', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('95', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('96', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('97', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('98', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('99', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('100', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('101', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('102', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('103', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('104', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('105', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('106', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('107', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('108', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('109', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('110', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('111', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('112', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('113', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('114', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('115', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('116', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('117', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('118', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('119', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('120', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('121', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('122', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('123', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('124', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('125', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('126', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('127', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('128', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('129', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('130', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('131', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('132', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('133', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('134', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('135', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('136', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('137', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('138', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('139', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('140', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('141', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('142', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('143', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('144', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('145', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('146', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('147', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('148', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('149', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('150', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('151', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('152', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('153', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('154', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('155', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('156', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('157', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('158', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('159', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('160', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('161', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('162', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('163', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('164', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('165', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('166', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('167', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('168', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('169', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('170', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('171', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('172', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('173', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('174', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('175', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('176', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('177', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('178', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('179', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('180', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('181', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('182', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('183', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('184', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('185', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('186', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('187', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('188', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('189', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('190', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('191', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('192', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('193', null, null, null, null);
commit;
prompt 200 records committed...
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('194', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('195', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('196', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('197', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('198', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('199', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('200', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('201', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('202', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('203', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('204', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('205', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('206', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('207', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('208', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('209', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('210', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('211', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('212', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('213', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('214', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('215', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('216', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('217', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('218', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('219', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('220', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('221', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('222', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('223', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('224', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('225', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('226', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('227', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('228', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('229', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('230', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('231', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('232', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('233', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('234', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('235', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('236', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('237', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('238', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('239', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('240', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('241', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('242', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('243', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('244', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('245', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('246', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('247', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('248', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('249', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('250', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('251', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('252', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('253', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('254', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('255', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('256', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('257', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('258', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('259', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('260', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('261', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('262', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('263', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('264', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('265', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('266', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('267', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('268', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('269', null, null, 0, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('270', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('271', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('272', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('273', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('274', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('275', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('276', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('277', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('278', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('279', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('280', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('281', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('282', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('283', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('284', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('285', null, null, null, null);
insert into BRY (YHID, SJHM, GW, FL, GWJB)
values ('286', null, null, null, null);
commit;
prompt 293 records loaded
prompt Loading BZDBB...
insert into BZDBB (ZDBBID, PTLX, BBH, WJDX)
values (1, 'iphone', '1.1.1.051021_beta', '0.556');
insert into BZDBB (ZDBBID, PTLX, BBH, WJDX)
values (2, 'android', '1.1.1.051021_beta', '0.774');
commit;
prompt 2 records loaded
prompt Loading HCGJH...
insert into HCGJH (CGJHHJID, CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ, CZR, CZSJ, CZLX)
values ('20140227162103203090', '20140227162103156089', '20140227141121765048', '�ʼǱ�����', 'EM6400', '̨', '˫��1g�ڴ�', '3��ԭ��ά�������˵渶ȫ���30%', 1, .8, to_date('07-03-2014', 'dd-mm-yyyy'), '1', to_date('27-02-2014 16:21:03', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HCGJH (CGJHHJID, CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ, CZR, CZSJ, CZLX)
values ('20140227162514609092', '20140227162514593091', '20140227141121765048', '����ϵͳ', 'win7', '��', '��ҵ�������lisence', 'ά����Ա���Ű�װ�������úð�ȫ��Ϣ', 1, 1.2, to_date('06-03-2014', 'dd-mm-yyyy'), '1', to_date('27-02-2014 16:25:14', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HCGJH (CGJHHJID, CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ, CZR, CZSJ, CZLX)
values ('20140228092306390004', '20140227162514593091', '20140227141121765048', '����ϵͳ', 'win7', '��', '��ҵ�������lisence', 'ά����Ա���Ű�װ�������úð�ȫ��Ϣ', 1, 1.2, to_date('06-03-2014', 'dd-mm-yyyy'), '1', to_date('28-02-2014 09:23:06', 'dd-mm-yyyy hh24:mi:ss'), '1');
insert into HCGJH (CGJHHJID, CGJHID, XMID, HWMC, XH, DW, JSTX, QTXX, SL, DJ, YQDHSJ, CZR, CZSJ, CZLX)
values ('20140228110320218020', '20140228110320203019', '20140227141121765048', '����', '8U', '��', '��ɫ����������', '�ṩһ��ά��', 1, .5, to_date('15-02-2014', 'dd-mm-yyyy'), '217', to_date('28-02-2014 11:03:20', 'dd-mm-yyyy hh24:mi:ss'), '0');
commit;
prompt 4 records loaded
prompt Loading HHKJH...
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140227143852515066', '20140227143852468065', '20140227141121765048', '20140227143136859054', '��ͬ50%��Լ�ؿ�', '����', to_date('01-07-2014', 'dd-mm-yyyy'), 60, '1', '1', '0', to_timestamp('27-02-2014 14:38:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140227143852531068', '20140227143852531067', '20140227141121765048', '20140227143136859054', '��ͬ������Լ�ؿ�', '����', to_date('01-09-2014', 'dd-mm-yyyy'), 30, '1', '1', '0', to_timestamp('27-02-2014 14:38:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140227143852546070', '20140227143852531069', '20140227141121765048', '20140227143136859054', '��ͬ������Լ�ؿ�', '�ͻ�ǩ����Լ����', to_date('31-12-2014', 'dd-mm-yyyy'), 10, '1', '1', '0', to_timestamp('27-02-2014 14:38:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140227143852546072', '20140227143852546071', '20140227141121765048', '20140227143136859054', null, null, null, 0, '0', '1', '0', to_timestamp('27-02-2014 14:38:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140227143852546074', '20140227143852546073', '20140227141121765048', '20140227143136859054', null, null, null, 0, '0', '1', '0', to_timestamp('27-02-2014 14:38:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140228111815640031', '20140228111815609030', '20140227141121765048', '20140228103510578010', '����׶�', '�ͻ�ǩ��������', to_date('28-02-2014', 'dd-mm-yyyy'), 30, '1', '217', '0', to_timestamp('28-02-2014 11:18:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140228111815656033', '20140228111815640032', '20140227141121765048', '20140228103510578010', '������Լ', '��Լ�������', to_date('01-11-2014', 'dd-mm-yyyy'), 60, '1', '217', '0', to_timestamp('28-02-2014 11:18:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140228111815656035', '20140228111815656034', '20140227141121765048', '20140228103510578010', '����', '��Ŀ���ձ���', to_date('31-12-2014', 'dd-mm-yyyy'), 10, '1', '217', '0', to_timestamp('28-02-2014 11:18:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140228111815656037', '20140228111815656036', '20140227141121765048', '20140228103510578010', null, null, null, 0, '0', '217', '0', to_timestamp('28-02-2014 11:18:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HHKJH (HKJHHJID, HKJHID, XMID, HTID, HKJDMC, HKQDBZJNR, JHSJ, HKBL, ZT, CZR, CZLX, CZSJ)
values ('20140228111815671039', '20140228111815656038', '20140227141121765048', '20140228103510578010', null, null, null, 0, '0', '217', '0', to_timestamp('28-02-2014 11:18:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 10 records loaded
prompt Loading HHTXX...
insert into HHTXX (HTHJID, HTID, XMID, HTMC, HTBH, HTQDSJ, HTE, ERPXMBH, HTLYJFSJ, HTLYJSSJ, KHMC, CZR, CZSJ, CZLX, XSDDH, HTZT)
values ('20140227143136875055', '20140227143136859054', '20140227141121765048', '�����ͷ�������Ϣϵͳ��ά', '2014-01-01-yw001', to_date('01-01-2014', 'dd-mm-yyyy'), 48, 'B34635140007', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), '1', '1', to_date('27-02-2014 14:31:36', 'dd-mm-yyyy hh24:mi:ss'), '0', '500192876', 'YQD');
insert into HHTXX (HTHJID, HTID, XMID, HTMC, HTBH, HTQDSJ, HTE, ERPXMBH, HTLYJFSJ, HTLYJSSJ, KHMC, CZR, CZSJ, CZLX, XSDDH, HTZT)
values ('20140228103510593011', '20140228103510578010', '20140227141121765048', '��ͬ1', 'HT1223', null, 100, 'ERP123', null, null, '28', '217', to_date('28-02-2014 10:35:10', 'dd-mm-yyyy hh24:mi:ss'), '0', 'SX111', 'YQD');
insert into HHTXX (HTHJID, HTID, XMID, HTMC, HTBH, HTQDSJ, HTE, ERPXMBH, HTLYJFSJ, HTLYJSSJ, KHMC, CZR, CZSJ, CZLX, XSDDH, HTZT)
values ('20140228103519015012', '20140228103510578010', null, '��ͬ1', 'HT1223', null, 100, 'ERP123', null, null, '28', '217', to_date('28-02-2014 10:35:19', 'dd-mm-yyyy hh24:mi:ss'), '1', 'SX111', 'WQD');
commit;
prompt 3 records loaded
prompt Loading HJDJH...
insert into HJDJH (JDJHHJID, JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ, CZR, CZLX, CZSJ)
values ('20140227144046046086', '20140227144046000085', '20140227141121765048', '21', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('28-02-2014', 'dd-mm-yyyy'), null, null, '��Ŀ��������Դ������', '1', '0', to_timestamp('27-02-2014 14:40:46.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HJDJH (JDJHHJID, JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ, CZR, CZLX, CZSJ)
values ('20140228092301906003', '20140227144046000085', '20140227141121765048', '21', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('28-02-2014', 'dd-mm-yyyy'), null, null, '��Ŀ��������Դ������', '1', '1', to_timestamp('28-02-2014 09:23:01.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HJDJH (JDJHHJID, JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ, CZR, CZLX, CZSJ)
values ('20140228103810187014', '20140228103810187013', '20140227141121765048', '����׶�', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-01-2014', 'dd-mm-yyyy'), null, null, 'Ϊ��ά��Ŀ����볡׼����' || chr(13) || '' || chr(10) || '�ͻ�ǩ���볡����', '217', '0', to_timestamp('28-02-2014 10:38:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HJDJH (JDJHHJID, JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ, CZR, CZLX, CZSJ)
values ('20140228103902000016', '20140228103902000015', '20140227141121765048', '����ʵʩ', to_date('01-02-2014', 'dd-mm-yyyy'), to_date('31-10-2014', 'dd-mm-yyyy'), null, null, '�Ժ�ͬ�ķ��������Լʵʩ��' || chr(13) || '' || chr(10) || 'ÿ���µķ��񱨸�', '217', '0', to_timestamp('28-02-2014 10:39:02.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into HJDJH (JDJHHJID, JDJHID, XMID, JDMC, JHKSSJ, JHJSSJ, SJKSSJ, SJJSSJ, GZNRJBZ, CZR, CZLX, CZSJ)
values ('20140228103945265018', '20140228103945250017', '20140227141121765048', '���ս׶�', to_date('01-10-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '������չ�����' || chr(13) || '' || chr(10) || '�ͻ�ǩ�����յ���', '217', '0', to_timestamp('28-02-2014 10:39:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 5 records loaded
prompt Loading HKPJH...
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140227143658015058', '20140227143657968057', '20140227141121765048', '20140227143136859054', '0002', 60, to_date('01-07-2014', 'dd-mm-yyyy'), '1', '1', to_date('27-02-2014 14:36:58', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140227143658046060', '20140227143658031059', '20140227141121765048', '20140227143136859054', '0002', 30, to_date('01-09-2014', 'dd-mm-yyyy'), '1', '1', to_date('27-02-2014 14:36:58', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140227143658046062', '20140227143658046061', '20140227141121765048', '20140227143136859054', '0002', 10, to_date('31-12-2014', 'dd-mm-yyyy'), '1', '1', to_date('27-02-2014 14:36:58', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140227143658046064', '20140227143658046063', '20140227141121765048', '20140227143136859054', '0002', 0, null, '0', '1', to_date('27-02-2014 14:36:58', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140228111534500023', '20140228111534484022', '20140227141121765048', '20140228103510578010', '0001', 60, to_date('01-06-2014', 'dd-mm-yyyy'), '1', '217', to_date('28-02-2014 11:15:34', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140228111534515025', '20140228111534515024', '20140227141121765048', '20140228103510578010', '0001', 30, to_date('01-11-2014', 'dd-mm-yyyy'), '1', '217', to_date('28-02-2014 11:15:34', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140228111534515027', '20140228111534515026', '20140227141121765048', '20140228103510578010', '0001', 10, to_date('31-12-2014', 'dd-mm-yyyy'), '1', '217', to_date('28-02-2014 11:15:34', 'dd-mm-yyyy hh24:mi:ss'), '0');
insert into HKPJH (KPJHHJID, KPJHID, XMID, HTID, KPLX, BL, JHSJ, ZT, CZR, CZSJ, CZLX)
values ('20140228111534515029', '20140228111534515028', '20140227141121765048', '20140228103510578010', '0001', 0, null, '0', '217', to_date('28-02-2014 11:15:34', 'dd-mm-yyyy hh24:mi:ss'), '0');
commit;
prompt 8 records loaded
prompt Loading HXMJBXX...
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228095642906008', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '57', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:56:42.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228095709328009', '20140227141147015050', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '5', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '1', to_timestamp('28-02-2014 09:57:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227141121781049', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '217', to_timestamp('27-02-2014 14:11:21.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227141147015051', '20140227141147015050', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '217', to_timestamp('27-02-2014 14:11:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227141229531053', '20140227141229531052', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ���ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '217', to_timestamp('27-02-2014 14:12:29.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '0');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227143513703056', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '1', to_timestamp('27-02-2014 14:35:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227160122687087', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:01:22.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227160133906088', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:01:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227163944875094', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:39:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227164325234096', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:43:25.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227164332781097', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:43:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227164400437098', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('27-02-2014 16:44:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140227172611625099', '20140227141229531052', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ���ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '1', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '1', to_timestamp('27-02-2014 17:26:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228092059187000', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '7', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:20:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228092101640001', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '7', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:21:01.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228092103562002', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '7', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:21:03.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228094948281005', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '7', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:49:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228095039843006', '20140227141121765048', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�����ͷ�������ά', '0006', '20140227113402953012', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '7', '����', '11111111111', 29, 12, 31.9, 8, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*�������ҵ����ͻ�����������Ϣϵͳ��ά��������~��@#��%����&*����', '1', to_timestamp('28-02-2014 09:50:39.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into HXMJBXX (XMHJID, XMID, XMBH, XMMC, XMJC, XMLX, ZRBM, XMJL, CPX, ZCPX, KSRQ, JSRQ, XSFZR, SQGCS, KHMC, KHFZR, LXFS, YJRS, GQ, RGCB, QTJJFY, SFXCP, XMJB, XMJS, CZR, CZSJ, CZLX)
values ('20140228095632218007', '20140227141229531052', 'B34635140007', '���ҵ����ͻ�����������Ϣϵͳ��ά', '�ͷ���ά', '0006', '20140227113319687007', '231', '0004', '18', to_date('01-01-2014', 'dd-mm-yyyy'), to_date('31-12-2014', 'dd-mm-yyyy'), null, null, '5', '����', '11111111111', 5, 12, 100, 20, '0', '0001', '���ҵ����ͻ�����������Ϣϵͳ��ά', '1', to_timestamp('28-02-2014 09:56:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
commit;
prompt 19 records loaded
prompt Loading PMISUSER...
prompt Table is empty
prompt Loading SBGX...
insert into SBGX (BGXID, BGXMC, GLBM, ZT)
values ('0003', '����֧��', '������ҵ��', '0');
insert into SBGX (BGXID, BGXMC, GLBM, ZT)
values ('0001', '������Ŀ', '������ҵ��', '1');
insert into SBGX (BGXID, BGXMC, GLBM, ZT)
values ('0002', '�ۺ�����', '������ҵ��', '0');
insert into SBGX (BGXID, BGXMC, GLBM, ZT)
values ('0004', 'Ӫ������', '������ҵ��', '0');
commit;
prompt 4 records loaded
prompt Loading SBM...
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113212859000', '�ۺϰ칫��', null, null, '1', null, null, '0001');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113221250001', '���ʲ�', null, null, '1', null, null, '0002');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113229453002', '���ʲ�', null, null, '1', null, null, '0003');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113240546003', '���ʲ�', null, null, '1', null, null, '0004');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113250843004', '��Ŀ����칫��', null, null, '1', null, '19', '0005');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113302125005', '������ҵ��', null, null, '1', null, null, '0006');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113311562006', 'ϵͳ���ɲ�', null, '0001', '1', null, null, '0007');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113319687007', '��ά��ҵ��', null, null, '1', null, '193', '0008');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113326906008', 'ERP��ҵ��', null, null, '1', null, null, '0009');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113335859009', '������̲�', null, null, '1', null, null, '0010');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113344906010', '�з���', null, null, '1', null, null, '0011');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113354843011', '��ͨ��ҵ��', null, null, '1', null, null, '0012');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113402953012', '��Ʒ���첿', null, null, '1', null, '263', '0013');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113412656013', 'GIS��ҵ��', null, null, '1', null, null, '0014');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113420078014', '��Զ��˾', null, null, '1', null, null, '0015');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113428000015', 'Ӫ����', null, null, '1', null, null, '0016');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227113435921016', '��չ��ҵ��', null, null, '1', null, null, '0017');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227123210234018', '������Ϣ������Ŀ��', null, null, '1', null, null, '0018');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131119156025', '���طֲ�', null, null, '1', null, null, '00010001');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131134140026', '��Ⱥ�ֲ�', null, null, '1', null, null, '00010002');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131147453027', '��ҵ�ֲ�', null, null, '1', null, null, '00010003');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131223625028', '�ۺϹ�������', null, null, '1', null, null, '00160001');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131236750029', '����һ����', null, null, '1', null, null, '00160002');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131249890030', '���۶�����', null, null, '1', null, null, '00160003');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131305625031', '����������', null, null, '1', null, null, '00160004');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131320562032', '����֧������', null, null, '1', null, null, '00160005');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131348671033', '�豸��������', null, null, '1', null, null, '00090001');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131359390034', '�����������', null, null, '1', null, null, '00090002');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131418625035', '������������', null, null, '1', null, null, '00090003');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131451968036', '���ʷ�������', null, null, '1', null, null, '00090004');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131508250037', '���ʷ�������', null, null, '1', null, null, '00090005');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131542593038', '��Ŀ��������', null, null, '1', null, null, '00090006');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131628015039', '���ɷ�������', null, null, '1', null, null, '00070001');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('20140227131650015040', '��Ʒ��������', null, null, '1', null, null, '00070002');
insert into SBM (BMID, BMMC, BMJC, BMLX, ZT, BZ, BMZR, BMBH)
values ('1', '����', '����', '1', '1', null, null, '9999');
commit;
prompt 35 records loaded
prompt Loading SCD...
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140224151845687000', '0002', '��������', 'CDJ', null, 1, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140226234056859002', '00020004', 'ͳ�Ʊ���', 'CDX', '/bui/bggl/tjbg.do?doAction=toTjbgList', 4, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140224173512656011', '00020002', '�ҵı���', 'CDX', '/bui/bggl/wdbg.do?doAction=toWdbgList', 2, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140224173532484012', '00020003', '��˱���', 'CDX', '/bui/bggl/shbg.do?doAction=toShbgList', 3, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140216101935403002', '99990005', '��������', 'CDX', '/sys/xtgl/dmk.do?doAction=toDmkList', 5, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('1', '9999', 'ϵͳ����', 'CDJ', null, 3, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('2', '99990001', '���Ź���', 'CDX', '/sys/xtgl/bm.do?doAction=toBmList', 1, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('4', '99990003', '��ɫ����', 'CDX', '/sys/xtgl/js.do?doAction=toJsList', 3, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('3', '99990002', '�û�����', 'CDX', '/sys/xtgl/xtyh.do?doAction=toXtyhList', 2, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('5', '99990004', '�˵�����', 'CDX', '/sys/xtgl/cd.do?doAction=toCdListWrapper', 4, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140216153051753004', '0001', '��Ŀ�ƻ�����', 'CDJ', null, 2, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140216153310872006', '00010001', '��Ŀ��Ϣ����', 'CDX', '/bui/xmqdgl/xmjbxx.do?doAction=toXmjbxxList', 1, null, '1');
insert into SCD (CDID, CDBH, CDMC, CDLX, FWLJ, PX, BZ, ZT)
values ('20140224155939864000', '99990006', '��ʷ��Ŀά��', 'CDX', '/bui/xmqdgl/xmjbxx.do?doAction=toLsxmUpdate', 6, null, '1');
commit;
prompt 13 records loaded
prompt Loading SJS...
insert into SJS (JSID, JSMC, JSMS, ZT)
values ('20140227135811984041', '���ù���Ա', '���ù���', '1');
insert into SJS (JSID, JSMC, JSMS, ZT)
values ('20140227135825375042', 'ְԱ', null, '1');
insert into SJS (JSID, JSMC, JSMS, ZT)
values ('1', '����Ա��ɫ', null, '1');
commit;
prompt 3 records loaded
prompt Loading SCD_JS...
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720334008', '20140227135811984041', '20140224151845687000');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720350009', '20140227135811984041', '20140224173532484012');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720350010', '20140227135811984041', '20140216153051753004');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720350011', '20140227135811984041', '20140216153310872006');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720350012', '20140227135811984041', '1');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140312105720366013', '20140227135811984041', '3');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546028', '1', '20140224151845687000');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546029', '1', '20140224173532484012');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546030', '1', '20140216153051753004');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546031', '1', '20140216153310872006');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546032', '1', '1');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912546033', '1', '2');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912562034', '1', '3');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912562035', '1', '4');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912562036', '1', '5');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912562037', '1', '20140216101935403002');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303120912562038', '1', '20140224155939864000');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303121214796000', '20140227135825375042', '20140224151845687000');
insert into SCD_JS (CD_JSID, JSID, CDID)
values ('20140303121214796001', '20140227135825375042', '20140224173532484012');
commit;
prompt 19 records loaded
prompt Loading SDMK...
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140216101636275000', '0001', 'BMLX', '��ҵ��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140216101715491001', '0002', 'BMLX', 'Ӫ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140216102425145011', '0003', 'BMLX', '�ɹ���', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140216102432347012', '0004', 'BMLX', '����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140216102437128013', '0005', 'BMLX', '����', '����������Ա��', '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115409822000', '0001', 'XMLX', '�������', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115419747001', '0002', 'XMLX', 'ϵͳ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115430601002', '0003', 'XMLX', 'ϵͳʵʩ', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115440009003', '0004', 'XMLX', '��Ϣ��ά', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115448831004', '0005', 'XMLX', '�������', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115458504005', '0006', 'XMLX', '��Ʒ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115511019006', '0007', 'XMLX', '������', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115520508007', '0008', 'XMLX', '��Ϣ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115531882008', '0009', 'XMLX', '�Ƽ��о�', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115540947009', '0010', 'XMLX', '��������', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115552628010', '0001', 'CPX', '��Ϣ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115601850011', '0002', 'CPX', '��ҵ��Ϣ��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115609733012', '0003', 'CPX', '��Ϣ��ȫ', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115618116013', '0004', 'CPX', '��Ϣϵͳ���ɼ���ά', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115626109014', '0005', 'CPX', '��Ϣͨ���ۺϼ��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115634298015', '0006', 'CPX', 'ͨ��ϵͳ��ͨ���豸', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115643205016', '0007', 'CPX', 'ͨ����Ӫ����ϵͳ����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115656013017', '0001', 'XMJB', 'A��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115706768018', '0002', 'XMJB', 'B��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115719238019', '0003', 'XMJB', 'C��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140217115725714020', '0004', 'XMJB', 'D��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140225160251375000', '0001', 'BGLX', '������Ŀ', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140225160521625001', '0002', 'BGLX', '�ۺ�����', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140225160531015002', '0003', 'BGLX', '����֧��', null, '1');
insert into SDMK (DMID, DMBH, DMFL, DMMC, DMMX, ZT)
values ('20140225160541203003', '0004', 'BGLX', 'Ӫ������', null, '1');
commit;
prompt 30 records loaded
prompt Loading SFILTER...
insert into SFILTER (FILTERID, URI)
values ('1', '/sys/login.do');
commit;
prompt 1 records loaded
prompt Loading SGW...
prompt Table is empty
prompt Loading SJDJD...
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('1', '0001', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('2', '0001', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('3', '0001', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('4', '0001', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('5', '0002', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('6', '0002', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('7', '0002', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('8', '0002', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('9', '0003', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('10', '0003', '�������');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('11', '0003', '����ȷ��');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('12', '0003', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('13', '0004', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('14', '0004', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('15', '0004', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('16', '0004', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('17', '0005', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('18', '0005', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('19', '0005', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('20', '0005', '��Ŀ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('21', '0006', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('22', '0007', '����ʵʩ');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('23', '0007', '�������');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('24', '0007', '��ȫ����');
insert into SJDJD (JDJDID, XMLX, JDJDMC)
values ('25', '0007', '��Ŀ����');
commit;
prompt 25 records loaded
prompt Loading SKHXX...
insert into SKHXX (KHID, KHMC)
values ('3', '���ݳ�Դ�����������޹�˾');
insert into SKHXX (KHID, KHMC)
values ('5', '����ʡ�ͱ�繤�̹�˾');
insert into SKHXX (KHID, KHMC)
values ('8', '���ռ�Զ���������������ι�˾');
insert into SKHXX (KHID, KHMC)
values ('13', '����ʡ�����������޹�˾');
insert into SKHXX (KHID, KHMC)
values ('24', '���յ�����ع����������ι�˾');
insert into SKHXX (KHID, KHMC)
values ('28', '��������������չͶ�ʼ������޹�˾');
insert into SKHXX (KHID, KHMC)
values ('57', '����ʡ������˾�������������ģ�');
insert into SKHXX (KHID, KHMC)
values ('94', '����ʡ������˾���ǹ��繫˾');
commit;
prompt 8 records loaded
prompt Loading SWBDW...
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('-1', null, null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('1', '�Ϻ���ԯ��Ϣ�����������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('2', '�Ϸ�������Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('3', '���ս�ȴ�ý�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('4', '�Ϸ�ʢ��������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('5', '�Ϸ����ǵ����������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('6', '���������ؿƼ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('7', '�Ϸʰ������Ϣ�������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('8', '�人γ��γ��', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('9', '������ͨ�����Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('10', '�Ϸʸ�������Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('11', '�Ϸʴ�����Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('12', '�Ϸʻ�����������������޹�˾���Ϸʻ�����', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('13', '����������ɽ', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('14', '�Ϸ���������Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('15', '�Ϸ���ͬ', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('16', '�Ϸʺ�˳��Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('17', '�Ĵ�������Ϣ��ҵ�ɷ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('18', '�Ϸʻ�����Ϣ�������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('19', '�Ϸ��ǳ���Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('20', '�Ϸ��׸�����', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('21', '�Ϸ��ʬB��Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('22', '�Ϸ�Ӣ��', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('23', '�Ͼ��칹�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('24', '�人��Ԫ', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('25', '�Ϻ���������Ϣ�������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('26', '�Ϸ��ǺϿƼ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('27', '�Ϻ��¾����缼�����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('28', '�п���Ƽ��ɷ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('29', '�Ϻ���ٵ����Ƽ��ɷ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('30', '�Ϸ�΢׿��Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('31', '����˫Դ�������¼����������ι�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('32', '���չȵ�', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('33', '���շɿ��Ƽ�', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('34', '������Ԫ', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('35', '�Ϸʵ�֪', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('36', '��������ɷ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('37', 'ɽ��³������������޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('38', '�������ư�����Ϣ�Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('39', '�Ϸ���������', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('40', 'IBM', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('41', '������������Ϣ��ҵ���޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('42', '�������', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('43', '���պ��', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('44', '���ݼ������Ƽ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('45', '�Ϻ�Զ��', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('46', '��Ԫ��Ϣ�����ɷ����޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('47', '���Ϻ��ǣ��Ͼ�����Ϣϵͳ���޹�˾', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('48', '��������', null, null, null);
insert into SWBDW (WBDWID, WBDWMC, LXR, LXDH, LXDZ)
values ('49', '����������ͨ��˾', null, null, null);
commit;
prompt 50 records loaded
prompt Loading SXTYH...
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('42', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('43', '20140227113435921016', '-1', '-1', 'Ҷ����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('44', '20140227113435921016', '-1', '-1', '��Ρ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('45', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('46', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('47', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('48', '20140227113435921016', '-1', '-1', '�쿭', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('49', '20140227113435921016', '-1', '-1', 'Ҷ����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('50', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('51', '20140227123210234018', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('52', '20140227123210234018', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('53', '20140227123210234018', '-1', '-1', '�ܶ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('54', '20140227123210234018', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('55', '20140227123210234018', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('56', '20140227123210234018', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('57', '20140227123210234018', '-1', '-1', 'Ԭ԰', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('58', '20140227113326906008', '-1', '-1', 'л�ƾ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('59', '20140227113326906008', '-1', '-1', '�캣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('60', '20140227113326906008', '-1', '-1', '���Ӻ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('61', '20140227113326906008', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('62', '20140227113335859009', '-1', '-1', '���Ż�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('63', '20140227113335859009', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('64', '20140227113335859009', '-1', '-1', '֣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('65', '20140227113335859009', '-1', '-1', '����ʤ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('66', '20140227113335859009', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('67', '20140227113335859009', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('68', '20140227113335859009', '-1', '-1', '�Ŵ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('69', '20140227113335859009', '-1', '-1', '���ٳ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('70', '20140227113335859009', '-1', '-1', '��־��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('71', '20140227113335859009', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('72', '20140227113335859009', '-1', '-1', '��־', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('73', '20140227113335859009', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('74', '20140227113335859009', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('75', '20140227113335859009', '-1', '-1', '��ʥ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('76', '20140227113335859009', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('77', '20140227113335859009', '-1', '-1', '�϶�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('78', '20140227113335859009', '-1', '-1', '���ʤ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('79', '20140227113335859009', '-1', '-1', '��ޱ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('80', '20140227113335859009', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('81', '20140227113335859009', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('86', '20140227113335859009', '-1', '-1', '��ʤ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('87', '20140227113335859009', '-1', '-1', '֣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('88', '20140227113344906010', '-1', '-1', '�·�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('89', '20140227113344906010', '-1', '-1', '��Ҷƽ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('90', '20140227113344906010', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('91', '20140227113344906010', '-1', '-1', '��ΰΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('92', '20140227113344906010', '-1', '-1', '�Ż�ǿ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('93', '20140227113344906010', '-1', '-1', 'Ԭ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('94', '20140227113344906010', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('95', '20140227113344906010', '-1', '-1', 'Ҧ����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('96', '20140227113344906010', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('97', '20140227113344906010', '-1', '-1', '��ԶԶ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('98', '20140227113344906010', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('99', '20140227113302125005', '-1', '-1', '�ܳ�', '96E79218965EB72C92A549DD5A330112', '1', '��������', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('100', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('101', '20140227113302125005', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('102', '20140227113302125005', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('103', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('104', '20140227113302125005', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('105', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('106', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('107', '20140227113302125005', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('108', '20140227113302125005', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('109', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('110', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('111', '20140227113302125005', '-1', '-1', '���黢', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('112', '20140227113302125005', '-1', '-1', '���ո�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('113', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('114', '20140227113302125005', '-1', '-1', '��ΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('115', '20140227113302125005', '-1', '-1', 'ţ־', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('116', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('117', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('118', '20140227113302125005', '-1', '-1', '�߳�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('119', '20140227113302125005', '-1', '-1', 'ʩ�˶�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('120', '20140227113302125005', '-1', '-1', '�Źھ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('121', '20140227113302125005', '-1', '-1', '��ά��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('122', '20140227113302125005', '-1', '-1', '�η�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('123', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('124', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('125', '20140227113302125005', '-1', '-1', '��˹ͮ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('126', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('127', '20140227113302125005', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('128', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('129', '20140227113302125005', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('130', '20140227113302125005', '-1', '-1', '��Х', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('131', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('132', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('133', '20140227113302125005', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('134', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('135', '20140227113311562006', '-1', '-1', '�غ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('136', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('137', '20140227113311562006', '-1', '-1', '�տ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('138', '20140227113311562006', '-1', '-1', '��ٻ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('139', '20140227113311562006', '-1', '-1', '¦����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('140', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('141', '20140227113311562006', '-1', '-1', '��ӯ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('142', '20140227113311562006', '-1', '-1', 'Ѧΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('143', '20140227113311562006', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('144', '20140227113311562006', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('145', '20140227113311562006', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
commit;
prompt 100 records committed...
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('146', '20140227113311562006', '-1', '-1', '�ƴ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('147', '20140227113311562006', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('148', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('149', '20140227113311562006', '-1', '-1', '��ǿ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('150', '20140227113311562006', '-1', '-1', '�ٷ�ī', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('151', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('152', '20140227113311562006', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('153', '20140227113311562006', '-1', '-1', '��˳��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('154', '20140227113311562006', '-1', '-1', '֣ͮ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('155', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('156', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('157', '20140227113311562006', '-1', '-1', 'Τ˼�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('158', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('159', '20140227113311562006', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('160', '20140227113311562006', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('161', '20140227113311562006', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('162', '20140227113354843011', '-1', '-1', '���ⷢ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('163', '20140227113354843011', '-1', '-1', 'ʯ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('164', '20140227113354843011', '-1', '-1', '���ݷ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('165', '20140227113354843011', '-1', '-1', '����ϼ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('166', '20140227113354843011', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('167', '20140227113354843011', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('168', '20140227113354843011', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('169', '20140227113354843011', '-1', '-1', '���ǰ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227115137078017', '20140227113402953012', null, '-1', 'zhangsan', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('170', '20140227113354843011', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('171', '20140227113354843011', '-1', '-1', '�»���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('172', '20140227113354843011', '-1', '-1', 'Ҷ־Զ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('173', '20140227113354843011', '-1', '-1', '����ͬ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('174', '20140227113354843011', '-1', '-1', '��־��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('175', '20140227113354843011', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('176', '20140227113354843011', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('177', '20140227113354843011', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('178', '20140227113354843011', '-1', '-1', '�¾�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('179', '20140227113354843011', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('180', '20140227113354843011', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('181', '20140227113354843011', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('182', '20140227113354843011', '-1', '-1', '�̶���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('183', '20140227113354843011', '-1', '-1', '����ȫ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('184', '20140227113354843011', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('185', '20140227113354843011', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('186', '20140227113354843011', '-1', '-1', '�޺���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('187', '20140227113354843011', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('188', '20140227113354843011', '-1', '-1', '�Ƶǻ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('189', '20140227113354843011', '-1', '-1', '�º���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('190', '20140227113354843011', '-1', '-1', '����ΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('191', '20140227113354843011', '-1', '-1', '��Ƶ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('192', '20140227113354843011', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('193', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('194', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('195', '20140227113319687007', '-1', '-1', '��껕F', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('196', '20140227113319687007', '-1', '-1', '��ӨӨ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('197', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('198', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('199', '20140227113319687007', '-1', '-1', '�𳿴�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('200', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('201', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('202', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('203', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('204', '20140227113319687007', '-1', '-1', '�»�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('205', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('206', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('207', '20140227113319687007', '-1', '-1', '�᳤��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('208', '20140227113319687007', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('209', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('210', '20140227113319687007', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('211', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('212', '20140227113319687007', '-1', '-1', '�ѽ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('213', '20140227113319687007', '-1', '-1', '���Ӵ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('214', '20140227113319687007', '-1', '-1', '���Ľ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('215', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('216', '20140227113319687007', '-1', '-1', '����ͤ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('217', '20140227113319687007', '-1', '-1', '̷����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('218', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('219', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('220', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('221', '20140227113319687007', '-1', '-1', '�ξ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('222', '20140227113319687007', '-1', '-1', '��Ծ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('223', '20140227113319687007', '-1', '-1', '½�겨', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('224', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('225', '20140227113319687007', '-1', '-1', 'л��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('226', '20140227113319687007', '-1', '-1', 'Ԭ����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('227', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('228', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('229', '20140227113319687007', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('230', '20140227113319687007', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('231', '20140227113319687007', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('232', '20140227113319687007', '-1', '-1', '��Դ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('233', '20140227113319687007', '-1', '-1', '��ѧ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('234', '20140227113319687007', '-1', '-1', '�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('235', '20140227113319687007', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('236', '20140227113412656013', '-1', '-1', 'κ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('237', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('238', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('239', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('240', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('241', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('242', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('243', '20140227113412656013', '-1', '-1', '�տ�2', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('244', '20140227113412656013', '-1', '-1', '�±�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
commit;
prompt 200 records committed...
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('245', '20140227113412656013', '-1', '-1', '��ɼ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('246', '20140227113412656013', '-1', '-1', '֣����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('247', '20140227113412656013', '-1', '-1', '֣����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('248', '20140227113412656013', '-1', '-1', '���׼�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('249', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('250', '20140227113412656013', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('251', '20140227113412656013', '-1', '-1', '��Ϊ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('252', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('253', '20140227113412656013', '-1', '-1', '�±�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('254', '20140227113412656013', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('255', '20140227113412656013', '-1', '-1', '�峬', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('256', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('257', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('258', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('259', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('260', '20140227113412656013', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('261', '20140227113412656013', '-1', '-1', 'ʯ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('262', '20140227113412656013', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('263', '20140227113402953012', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('264', '20140227113402953012', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('265', '20140227113402953012', '-1', '-1', '����2', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('266', '20140227113402953012', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('267', '20140227113402953012', '-1', '-1', '��¹��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('268', '20140227113402953012', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('269', '20140227113402953012', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('270', '20140227113420078014', '-1', '-1', '��ͬ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('271', '20140227113420078014', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('272', '20140227113420078014', '-1', '-1', '�캣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('273', '20140227113420078014', '-1', '-1', 'ξ˫÷', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('274', '20140227113420078014', '-1', '-1', '����Ƽ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('275', '20140227113420078014', '-1', '-1', '���º�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('276', '20140227113420078014', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('277', '20140227113420078014', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('278', '20140227113420078014', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('279', '20140227113420078014', '-1', '-1', '�Ų�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('280', '20140227113420078014', '-1', '-1', '��һ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('281', '20140227113420078014', '-1', '-1', '�溣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('282', '20140227113420078014', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('283', '20140227113420078014', '-1', '-1', 'Ҷ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('284', '20140227113420078014', '-1', '-1', '��ޱޱ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('285', '20140227113420078014', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('286', '20140227113420078014', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130455515019', '20140227113212859000', null, '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130508390020', '20140227113212859000', null, '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130522375021', '20140227113212859000', null, '-1', '�ܽ�', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130809125022', '20140227113428000015', null, '-1', '������1', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130824468023', '20140227113428000015', null, '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140227130834828024', '20140227113428000015', null, '-1', '�ܾ�', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20140228114002500040', '20140227113335859009', null, '13', 'asd', '96E79218965EB72C92A549DD5A330112', '1', null, '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('82', '20140227113335859009', '-1', '-1', '����ʤ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('83', '20140227113335859009', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('84', '20140227113335859009', '-1', '-1', '��ƽ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('85', '20140227113335859009', '-1', '-1', '��·�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('1', '1', null, null, 'admin', '1A1DC91C907325C69271DDF0C944BC72', '1', null, null);
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('2', '20140227113221250001', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('3', '20140227113221250001', '-1', '-1', '֣��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('4', '20140227113221250001', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('5', '20140227113221250001', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('6', '20140227113221250001', '-1', '-1', '�Ž�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('7', '20140227113221250001', '-1', '-1', '��ٻ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('8', '20140227113229453002', '-1', '-1', '�Ž�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('9', '20140227113229453002', '-1', '-1', '�ܿ�ǿ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('10', '20140227113229453002', '-1', '-1', '�³�ϼ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('11', '20140227113229453002', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('12', '20140227113229453002', '-1', '-1', '���ľ�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('13', '20140227113229453002', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('14', '20140227113229453002', '-1', '-1', '����ΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('15', '20140227113229453002', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('16', '20140227113229453002', '-1', '-1', '��··', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('17', '20140227113229453002', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('18', '20140227113250843004', '-1', '-1', '������02', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('19', '20140227113250843004', '-1', '-1', '�º���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('20', '20140227113250843004', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('21', '20140227113250843004', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('22', '20140227113250843004', '-1', '-1', '�־�', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('23', '20140227113250843004', '-1', '-1', '����ϼ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('24', '20140227113250843004', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('25', '20140227113250843004', '-1', '-1', '׿����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('26', '20140227113240546003', '-1', '-1', '�º�÷', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('27', '20140227113240546003', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('28', '20140227113240546003', '-1', '-1', '��ѩ��', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('29', '20140227113240546003', '-1', '-1', '�����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('30', '20140227113240546003', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('31', '20140227113240546003', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('32', '20140227113240546003', '-1', '-1', '������', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('33', '20140227113240546003', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('34', '20140227113240546003', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('35', '20140227113240546003', '-1', '-1', '�ƺ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('36', '20140227113435921016', '-1', '-1', '���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('37', '20140227113435921016', '-1', '-1', '��ΰ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('38', '20140227113435921016', '-1', '-1', '��ϼ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('39', '20140227113435921016', '-1', '-1', '�ܷ���', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('40', '20140227113435921016', '-1', '-1', '����', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
insert into SXTYH (YHID, BMID, GWID, WBDWID, YHXM, DLKL, ZT, BZ, FBID)
values ('41', '20140227113435921016', '-1', '-1', '��ӱ', '96E79218965EB72C92A549DD5A330112', '1', '�ޡ�', '-1');
commit;
prompt 294 records loaded
prompt Loading SXTYH_JS...
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140227140051187047', '217', '20140227135811984041');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('1', '1', '1');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172640365000', '269', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172646928001', '268', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172703131002', '266', '20140227135811984041');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172803115007', '267', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172744584004', '263', '1');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172749881005', '264', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140303172754444006', '265', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140304100308953001', '231', '20140227135825375042');
insert into SXTYH_JS (YH_JSID, YHID, JSID)
values ('20140304100445140002', '213', '20140227135825375042');
commit;
prompt 11 records loaded
prompt Loading SYJFK...
insert into SYJFK (YJFKID, FBR, LYRQ, YJNR, HFSJ, HFNR, ZT, BZ)
values ('20140307173056156000', '266', to_timestamp('07-03-2014 17:30:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '���޸Ľ���123', to_timestamp('07-03-2014 17:31:24.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '�õ�', '1', null);
insert into SYJFK (YJFKID, FBR, LYRQ, YJNR, HFSJ, HFNR, ZT, BZ)
values ('20140307173436687001', '268', to_timestamp('07-03-2014 17:34:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '��22222', to_timestamp('09-03-2014 10:08:07.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '�õ�', '1', null);
insert into SYJFK (YJFKID, FBR, LYRQ, YJNR, HFSJ, HFNR, ZT, BZ)
values ('20140307164941781010', '269', to_timestamp('07-03-2014 16:49:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '���޸ĵ�¼����', to_timestamp('07-03-2014 16:58:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '�õ�', '1', null);
commit;
prompt 3 records loaded
prompt Loading SZCPX...
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('1', '0001', '������������');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('2', '0001', '�������ȹ���');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('3', '0001', '����Ӫ������');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('4', '0001', '�����滮����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('5', '0001', '�����������');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('6', '0001', 'Эͬ�칫����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('7', '0001', '�ۺϹ���');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('8', '0001', '��ҵ��Ӧ�ü��ɼ����ɷ���');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('9', '0001', '���ܷ��������');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('10', '0001', 'ʵʱ���ݿ⼰Ӧ��');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('11', '0001', '�ռ������Ϣƽ̨��Ӧ��');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('12', '0001', '������Ϣ����ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('13', '0002', '��ҵ��Դ�ƻ�(ERP)');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('14', '0002', '��ҵ��Ϣ����ѯ����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('15', '0003', '��Ϣ��ȫ�豸������ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('16', '0003', '��Ϣ��ȫ��ѯ����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('17', '0004', '������Ϣ���������豸����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('18', '0004', '��Ϣϵͳ��ά');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('19', '0004', '���ݣ����֣����Ľ���');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('20', '0004', '�Ƽ���Ӧ��');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('21', '0004', '������Ϣϵͳ���ɼ�����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('22', '0005', '��Ϣͨ���ۺϼ�ܼ���ѯ����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('23', '0005', '�ۺ�����ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('24', '0006', '�������豸');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('25', '0006', 'ҵ�����豸');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('26', '0006', '֧�����豸');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('27', '0006', '�ն�ͨ�Ž������豸');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('28', '0007', 'ͨ��������Ӫ��ά��');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('29', '0007', 'Ӧ��ָ�Ӽ�ͨ��ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('30', '0007', '��Ƶ���ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('31', '0007', '����ͨ��ϵͳ����');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('32', '0008', '��绷�ڸ�֪ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('33', '0008', '��绷�ڸ�֪ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('34', '0008', '��绷�ڸ�֪ϵͳ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('35', '0009', '��ȫ��оƬ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('36', '0009', 'ͨ����оƬ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('37', '0009', '������оƬ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('38', '0009', '��Ƶ��ǩ��оƬ');
insert into SZCPX (ZCPXID, CPX, ZCPXMC)
values ('39', '0009', 'ʱ����оƬ');
commit;
prompt 39 records loaded
prompt Enabling foreign key constraints for BCGJH...
alter table BCGJH enable constraint FK_BCGJH_FK_CGYQ_H_BXMJBXX;
prompt Enabling foreign key constraints for BHTXX...
alter table BHTXX enable constraint FK_BHTXX_FK_HTXX_X_BXMJBXX;
prompt Enabling foreign key constraints for BHKJH...
alter table BHKJH enable constraint FK_BHKJH_FK_HKJH_H_BHTXX;
alter table BHKJH enable constraint FK_BHKJH_FK_HKYQ_H_BXMJBXX;
prompt Enabling foreign key constraints for BJDJH...
alter table BJDJH enable constraint FK_BJDJH_FK_JDYQ_H_BXMJBXX;
prompt Enabling foreign key constraints for BKPJH...
alter table BKPJH enable constraint FK_BKPJH_FK_KPJH_H_BHTXX;
alter table BKPJH enable constraint FK_BKPJH_FK_KPYQ_H_BXMJBXX;
prompt Enabling foreign key constraints for BLWWBCGJH...
alter table BLWWBCGJH enable constraint FK_BLWWBCGJ_REFERENCE_BXMJBXX;
prompt Enabling foreign key constraints for SCD_JS...
alter table SCD_JS enable constraint FK_SCD_JS_FK_CDJS_J_SJS;
alter table SCD_JS enable constraint FK_SCD_JS_FK_YHJS_J_SCD;
prompt Enabling foreign key constraints for SXTYH...
alter table SXTYH enable constraint FK_SXTYH_FK_YH_BMI_SBM;
alter table SXTYH enable constraint FK_SXTYH_FK_YH_WBD_SWBDW;
prompt Enabling foreign key constraints for SXTYH_JS...
alter table SXTYH_JS enable constraint FK_SXTYH_JS_FK_YHJS_J_SJS;
alter table SXTYH_JS enable constraint FK_SXTYH_JS_FK_YHJS_Y_SXTYH;
prompt Enabling triggers for BBG...
alter table BBG enable all triggers;
prompt Enabling triggers for BBGSHTHJL...
alter table BBGSHTHJL enable all triggers;
prompt Enabling triggers for BXMJBXX...
alter table BXMJBXX enable all triggers;
prompt Enabling triggers for BCGJH...
alter table BCGJH enable all triggers;
prompt Enabling triggers for BHTXX...
alter table BHTXX enable all triggers;
prompt Enabling triggers for BHKJH...
alter table BHKJH enable all triggers;
prompt Enabling triggers for BJDJH...
alter table BJDJH enable all triggers;
prompt Enabling triggers for BKPJH...
alter table BKPJH enable all triggers;
prompt Enabling triggers for BLSXMCB...
alter table BLSXMCB enable all triggers;
prompt Enabling triggers for BLWWBCGJH...
alter table BLWWBCGJH enable all triggers;
prompt Enabling triggers for BRY...
alter table BRY enable all triggers;
prompt Enabling triggers for BZDBB...
alter table BZDBB enable all triggers;
prompt Enabling triggers for HCGJH...
alter table HCGJH enable all triggers;
prompt Enabling triggers for HHKJH...
alter table HHKJH enable all triggers;
prompt Enabling triggers for HHTXX...
alter table HHTXX enable all triggers;
prompt Enabling triggers for HJDJH...
alter table HJDJH enable all triggers;
prompt Enabling triggers for HKPJH...
alter table HKPJH enable all triggers;
prompt Enabling triggers for HXMJBXX...
alter table HXMJBXX enable all triggers;
prompt Enabling triggers for PMISUSER...
alter table PMISUSER enable all triggers;
prompt Enabling triggers for SBGX...
alter table SBGX enable all triggers;
prompt Enabling triggers for SBM...
alter table SBM enable all triggers;
prompt Enabling triggers for SCD...
alter table SCD enable all triggers;
prompt Enabling triggers for SJS...
alter table SJS enable all triggers;
prompt Enabling triggers for SCD_JS...
alter table SCD_JS enable all triggers;
prompt Enabling triggers for SDMK...
alter table SDMK enable all triggers;
prompt Enabling triggers for SFILTER...
alter table SFILTER enable all triggers;
prompt Enabling triggers for SGW...
alter table SGW enable all triggers;
prompt Enabling triggers for SJDJD...
alter table SJDJD enable all triggers;
prompt Enabling triggers for SKHXX...
alter table SKHXX enable all triggers;
prompt Enabling triggers for SWBDW...
alter table SWBDW enable all triggers;
prompt Enabling triggers for SXTYH...
alter table SXTYH enable all triggers;
prompt Enabling triggers for SXTYH_JS...
alter table SXTYH_JS enable all triggers;
prompt Enabling triggers for SYJFK...
alter table SYJFK enable all triggers;
prompt Enabling triggers for SZCPX...
alter table SZCPX enable all triggers;
set feedback on
set define on
prompt Done.
