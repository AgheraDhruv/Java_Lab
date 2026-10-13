class ChatFilter {
    void filter(String[] logs, String keyword) {
        int count =0;
        StringBuilder report = new StringBuilder();
        for(String line : logs) {
            String parts[] = line.split(" ", 3);

            if(parts.length < 3) {
                continue;
            }

            if(parts[2].toLowerCase().contains(keyword.toLowerCase())) {
                count++;
                report.append(parts[0]);
                report.append(" ");
                report.append(parts[1]);
                report.append(": ");
                report.append(parts[2]);
                report.append("\n");
            }
        }
        System.out.println("Matches :" + count);
        System.out.println(report);
    }
}