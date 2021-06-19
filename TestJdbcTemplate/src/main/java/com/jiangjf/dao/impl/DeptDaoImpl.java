package com.jiangjf.dao.impl;

import com.jiangjf.dao.DeptDao;
import com.jiangjf.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取部门数量
     *
     * @return
     */
    @Override
    public int getDeptCount() {
        String sql = "select count(1) from dept";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 通过部门编号获取部门信息
     *
     * @param deptno
     * @return
     */
    @Override
    public Dept findByDeptno(int deptno) {
        // JdbcTemplate底层使用是的PreparedStatement，所以参数方式使用?
        String sql = "select * from dept where deptno = ?";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper(Dept.class);
        Object[] args = {deptno};
        return jdbcTemplate.queryForObject(sql, rowMapper, args);
    }

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Dept> findAll() {
        String sql = "select * from dept";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 更新部门信息
     *
     * @param dept
     * @return
     */
    @Override
    public int updateDept(Dept dept) {
        String sql = "update dept set dname = ?, loc = ? where deptno = ?";
        Object[] args = {dept.getDname(), dept.getLoc(), dept.getDeptno()};
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 添加部门
     *
     * @param dept
     * @return
     */
    @Override
    public int addDept(Dept dept) {
        String sql = "insert into dept(deptno, dname, loc) values(DEFAULT, ?, ?)";
        Object[] args = {dept.getDname(), dept.getLoc()};
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 删除部门
     *
     * @param deptno
     * @return
     */
    @Override
    public int deleteDept(int deptno) {
        String sql = "delete from dept where deptno = ?";
        return jdbcTemplate.update(sql, deptno);
    }

    /**
     * 批量添加部门
     *
     * @param deptList
     * @return
     */
    @Override
    public int[] batchAdd(List<Dept> deptList) {
        String sql = "insert into dept(deptno, dname, loc) values(?, ?, ?)";
        List<Object[]> args = new ArrayList<>();
        for (Dept dept : deptList) {
            Object[] arg = {dept.getDeptno(), dept.getDname(), dept.getLoc()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    /**
     * 批量更新部门信息
     *
     * @param deptList
     * @return
     */
    @Override
    public int[] batchUpdate(List<Dept> deptList) {
        String sql = "update dept set dname = ?, loc = ? where deptno = ?";
        List<Object[]> args = new ArrayList<>();
        for (Dept dept : deptList) {
            Object[] arg = {dept.getDname(), dept.getLoc(), dept.getDeptno()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    /**
     * 批量删除部门
     *
     * @param deptnos
     * @return
     */
    @Override
    public int[] batchDelete(List<Integer> deptnos) {
        String sql = "delete from dept where deptno = ?";
        List<Object[]> args = new ArrayList<>();
        for (Integer deptno : deptnos) {
            Object[] arg = {deptno};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}
