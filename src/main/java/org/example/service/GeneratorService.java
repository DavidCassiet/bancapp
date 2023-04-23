package org.example.service;

public interface GeneratorService {
    default String generateAccNumber(int branchId) {
        String stringBranchId;
        String randomNumber = String.valueOf(Math.round((Math.random() * 1000000 + 10000000)));

        if (branchId < 10) {
            stringBranchId = "00" + branchId;
        } else if (branchId < 100) {
            stringBranchId = "0" + branchId;
        } else {
            stringBranchId = String.valueOf(branchId);
        }
        String accountNumber = stringBranchId + randomNumber;

        return accountNumber;
    }

    default String generateCBU() {
        long min = 100000000000000000L;
        long max = 999999999999999999L;
        String cbu = String.valueOf(Math.round((Math.random() * max + min)));

        return cbu;
    }
}
