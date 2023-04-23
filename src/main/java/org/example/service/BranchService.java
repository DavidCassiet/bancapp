package org.example.service;

import org.example.entity.Branch;
import org.example.exception.MyException;
import org.example.repository.BranchRepository;

import java.util.ArrayList;

public class BranchService implements BranchRepository {
    private static final ArrayList<Branch> branches = BranchRepository.branches;
    private static int counter = 0;

    public Branch createBranch(String name, String address) {
        Branch objBranch = new Branch(++counter, name, address);
        branches.add(objBranch);

        return objBranch;
    }

    public Branch getBranchById(int branchId) throws MyException {
        for (Branch objBranch : branches) {
            if (objBranch.getId() == branchId) {
                return objBranch;
            }
        }
        throw new MyException("Sucursal no encontrada.");
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void updateBranch(int branchId, String name, String address) throws MyException {
        Branch objBranch = getBranchById(branchId);
        objBranch.setName(name);
        objBranch.setAddress(address);
    }

    public void deleteBranch(int branchId) throws MyException {
        Branch objBranch = getBranchById(branchId);
        branches.remove(objBranch);
    }
}
