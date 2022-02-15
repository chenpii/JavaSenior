package com.ch.team.service;

import com.ch.team.domain.Architect;
import com.ch.team.domain.Designer;
import com.ch.team.domain.Employee;
import com.ch.team.domain.Programmer;

/**
 * 关于开发团队成员的管理：添加、删除等。
 *
 * @author chenpi
 * @Descrition
 */
public class TeamService {
    private static int counter = 1;// 给memerID赋值使用
    private final int MAX_MEMBER = 5;// 限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发团队成员对象
    private int total;// 记录开发团队中实际的人数

    private int numOfArchitect;// 开发团队中架构师数量
    private int numOfDesigner;// 开发团队中设计师数量
    private int numOfProgrammer;// 开发团队中程序员数量

    public TeamService() {
        super();
    }

    /**
     * @return
     * @Descrition 获取开发团队成员
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @param e
     * @throws TeamException
     * @Descrition 将指定的员工添加到开发团队中
     */
    public void addMember(Employee e) throws TeamException {
        // 成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }

        // 该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        // 该员工已在本开发团队中
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        // 该员工已是某团队成员
        Programmer p = (Programmer) e;
//		if (Status.BUSY.equals(p.getStatus().getNAME())) {
//			throw new TeamException("该员工已是某团队成员");
//		}
//
//		// 该员工正在休假，无法添加
//		if (Status.VOCATION.equals(p.getStatus().getNAME())) {
//			throw new TeamException("该员工正在休假，无法添加");
//		}
        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员工正在休假，无法添加");
        }

        // 团队中至多只能有一名架构师
        // 团队中至多只能有两名设计师
        // 团队中至多只能有三名程序员
        if (p instanceof Architect) {
            if (numOfArchitect >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDesigner >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfProgrammer >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        // 将p(e)添加到现有的team中
        team[total++] = p;
        if (p instanceof Architect) {
            numOfArchitect++;
        } else if (p instanceof Designer) {
            numOfDesigner++;
        } else if (p instanceof Programmer) {
            numOfProgrammer++;
        }

        // p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberid(counter++);

    }

    /**
     * @param e
     * @return
     * @Descrition 判断指定的员工是否已存在该团队里
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param memberId
     * @throws TeamException
     * @Descrition 删除团队成员
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        Programmer p = null;
        for (; i < total; i++) {
            if (team[i].getMemberid() == memberId) {
                team[i].setStatus(Status.FREE);
                p = team[i];
                break;
            }
        }
        // 没找到，退出循环后i是toal
        if (i == total) {
            throw new TeamException("没找到该成员");
        }

        // 后一个元素覆盖前一个元素，实现删除操作
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
            int memberid2 = team[j].getMemberid();
            memberid2--;
            team[j].setMemberid(memberid2);
        }

        team[total - 1] = null;
        total--;
        counter--;

        if (p != null) {
            p.setMemberid(0);
            if (p instanceof Architect) {
                numOfArchitect--;
            } else if (p instanceof Designer) {
                numOfDesigner--;
            } else if (p instanceof Programmer) {
                numOfProgrammer--;
            }
        }

    }
}
