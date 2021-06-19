package com.jiangjf.service;

import com.jiangjf.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 获取部门数量
     *
     * @return
     */
    int getDeptCount();

    /**
     * 通过部门编号获取部门信息
     *
     * @param deptno
     * @return
     */
    Dept findByDeptno(int deptno);

    /**
     * 获取所有部门
     *
     * @return
     */
    List<Dept> findAll();

    /**
     * 更新部门信息
     *
     * @param dept
     * @return
     */
    int updateDept(Dept dept);

    /**
     * 添加部门
     *
     * @param dept
     * @return
     */
    int addDept(Dept dept);

    /**
     * 删除部门
     *
     * @param deptno
     * @return
     */
    int deleteDept(int deptno);

    /**
     * 批量添加部门
     *
     * @param deptList
     * @return
     */
    int[] batchAdd(List<Dept> deptList);

    /**
     * 批量更新部门信息
     *
     * @param deptList
     * @return
     */
    int[] batchUpdate(List<Dept> deptList);

    /**
     * 批量删除部门
     *
     * @param deptnos
     * @return
     */
    int[] batchDelete(List<Integer> deptnos);
}
