package com.wanglei.business.Util;

import com.google.common.collect.ImmutableList;
import com.wanglei.business.enums.TicketStatus;

import java.util.List;
import java.util.stream.Collectors;


public class Test {
    public static void main(String[] args) {
        ImmutableList<TicketStatus> ticketStatuses = ImmutableList.copyOf(TicketStatus.values());
        List<Integer> ticketStatusList = ticketStatuses.stream().filter(e -> TicketStatus.SOLDEND != e)
                .map(TicketStatus::getCode)
                .collect(Collectors.toList());
        System.out.println(ticketStatusList);

    }
}
