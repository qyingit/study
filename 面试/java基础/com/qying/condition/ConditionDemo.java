package com.qying.condition;

import org.junit.Test;

//��Ŀ���߳�֮�䰴˳����ã�ʵ��A->B->C˳��
//A�̴߳�ӡ5�Σ�B�̴߳�ӡ10�Σ�C�̴߳�ӡ5��
//�����ظ�10��
public class ConditionDemo {
    @Test
    public void demo() {
        SharedData data = new SharedData();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                data.aPrint();
            }
        }, "�߳�A").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                data.bPrint();
            }
        }, "�߳�B").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                data.cPrint();
            }
        }, "�߳�C").start();

        //��������
        //�߳�A0
        //�߳�A1

        //�������϶��Ǵ���ģ����Ǵ�����������Ƶ���һ��
    }
}