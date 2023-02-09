COPY bugs(bug_id,device_id,tester_id) FROM '${basedir}\src\main\resources\bugs.csv' DELIMITER ',' CSV;
COPY devices(device_id,description) FROM '${basedir}\src\main\resources\devices.csv' DELIMITER ',' CSV;
COPY tester_device(tester_id,device_id) FROM '${basedir}\src\main\resources\tester_device.csv' DELIMITER ',' CSV;
COPY testers(tester_id,first_name,last_name,country,last_login) FROM '${basedir}\src\main\resources\testers.csv' DELIMITER ',' CSV;