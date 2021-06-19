package com.jiangjf.service.impl;

import com.jiangjf.dao.DeptDao;
import com.jiangjf.pojo.Dept;
import com.jiangjf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    /**
     * 获取部门数量
     *
     * @return
     */
    @Override
    public int getDeptCount() {
        return deptDao.getDeptCount();
    }

    /**
     * 通过部门编号获取部门信息
     *
     * @param deptno
     * @return
     */
    @Override
    public Dept findByDeptno(int deptno) {
        return deptDao.findByDeptno(deptno);
    }

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    /**
     * 更新部门信息
     *
     * @param dept
     * @return
     */
    @Override
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    /**
     * 添加部门
     *
     * @param dept
     * @return
     */
    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    /**
     * 删除部门
     *
     * @param deptno
     * @return
     */
    @Override
    public int deleteDept(int deptno) {
        return deptDao.deleteDept(deptno);
    }

    /**
     * 批量添加部门
     *
     * @param deptList
     * @return
     */
    @Override
    public int[] batchAdd(List<Dept> deptList) {
        return deptDao.batchAdd(deptList);
    }

    /**
     * 批量更新部门信息
     *
     * @param deptList
     * @return
     */
    @Override
    public int[] batchUpdate(List<Dept> deptList) {
        return deptDao.batchUpdate(deptList);
    }

    /**
     * 批量删除部门
     *
     * @param deptnos
     * @return
     */
    @Override
    public int[] batchDelete(List<Integer> deptnos) {
        return deptDao.batchDelete(deptnos);
    }
}
