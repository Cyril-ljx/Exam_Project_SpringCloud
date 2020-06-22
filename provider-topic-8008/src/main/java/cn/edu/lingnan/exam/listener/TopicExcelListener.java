package cn.edu.lingnan.exam.listener;

import cn.edu.lingnan.exam.entity.Topic;
import cn.edu.lingnan.exam.service.TopicService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class TopicExcelListener extends AnalysisEventListener<Topic> {

    private List<Topic> data = new ArrayList<>();

    private TopicService topicService;

    public TopicExcelListener(TopicService topicService){
        this.topicService=topicService;
    }

    public void invoke(Topic topicExcel, AnalysisContext analysisContext){
        data.add(topicExcel);
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当Excel解析完毕后，执行
        System.out.println(data);
        if (topicService != null) {
            topicService.insert(data);
        }
    }
}
