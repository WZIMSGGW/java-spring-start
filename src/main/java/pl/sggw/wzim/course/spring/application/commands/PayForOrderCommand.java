package pl.sggw.wzim.course.spring.application.commands;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PayForOrderCommand {
    public final long orderId;
}
