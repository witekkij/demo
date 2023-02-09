COPY bugs(bugId,deviceId,testerId) FROM '${basedir}\src\main\resources\bugs.csv' DELIMITER ',' CSV;
COPY devices(deviceId,description) FROM '${basedir}\src\main\resources\devices.csv' DELIMITER ',' CSV;
COPY tester_device(testerId,deviceId) FROM '${basedir}\src\main\resources\tester_device.csv' DELIMITER ',' CSV;
COPY testers(testerId,firstName,lastName,country,lastLogin) FROM '${basedir}\src\main\resources\testers.csv' DELIMITER ',' CSV;