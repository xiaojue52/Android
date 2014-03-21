prompt PL/SQL Developer import file
prompt Created on 2014Äê3ÔÂ19ÈÕ by Administrator
set feedback off
set define off
prompt Loading BZDBB...
insert into BZDBB (ZDBBID, PTLX, BBH, WJDX)
values (1, 'iphone', '1.1.1.051021_beta', '0.556');
insert into BZDBB (ZDBBID, PTLX, BBH, WJDX)
values (2, 'android', '1.1.1.051021_beta', '0.774');
commit;
prompt 2 records loaded
set feedback on
set define on
prompt Done.
