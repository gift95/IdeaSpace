package cn.yunhe.practice;

import cn.yunhe.beans.User;

import java.util.Comparator;

/**
 * ������ͬ������������
 */
public class CompareByAgeAndName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        User user1 = (User) o1;
        User user2 = (User) o2;
		/*//�õ���������Ĳ�ֵ
		int ageResult = user1.getAge() - user2.getAge();
		//������ͬʱ��name���ֵ�˳������
		if(ageResult != 0){
			return ageResult;
		}
		return user1.getName().compareTo(user2.getName());*/
        int ageResult = user1.getAge() - user2.getAge();
        return ageResult == 0 ? (user1.getName().compareTo(user2.getName())) : ageResult;
    }

}
