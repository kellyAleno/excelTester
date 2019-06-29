import csv
import json
import pandas as pd
import numpy as np
import io


if __name__ == "__main__":
    header = ["intent", "confidence", "input", "output"]
    possible_emotional_vars = ["PersonaTurn_IsTalking",
                               "Persona_Turn_Negativity",
                               "UserTurn_IsAttentive",
                               "UserTurn_IsTalking",
                               "User_Turn_Negativity",
                               "User_Turn_Positivity",
                               "Time"]

    vogue_file = "voguecode.txt"
    vogue_str = open(vogue_file, 'r').read()
    print(header)
    vogue_parsed = json.loads(vogue_str)
    vogue_data = vogue_parsed['logs']

    # open a file for writing
    vogue_csv1 = open('intents.csv', 'w')
    vogue_request_emotions = open('request_emotions.csv', 'w')
    vogue_response_emotions = open('response_emotions.csv', 'w')


    # create the csv writer object
    csvwriter1 = csv.writer(vogue_csv1, delimiter="|")
    request_emotion_writer = csv.writer(vogue_request_emotions, delimiter="|")
    response_emotion_writer = csv.writer(vogue_response_emotions, delimiter="|")

    count = 0

    for convo in vogue_data:
        if count == 0:
            csvwriter1.writerow(header)
            request_emotion_writer.writerow(possible_emotional_vars)
            response_emotion_writer.writerow(possible_emotional_vars)
            possible_emotional_vars.remove("Time")
            count += 1

        request_emotion_arr = []
        response_emotion_arr = []

        for emotion in possible_emotional_vars:
            if emotion in convo["request"]["context"]:
                request_emotion_arr.append(convo["request"]["context"][emotion])
            else:
                request_emotion_arr.append(0)

            if emotion in convo["response"]["context"]:
                response_emotion_arr.append(convo["response"]["context"][emotion])
            else:
                response_emotion_arr.append(0)

        curr_time = convo["response"]["context"]["Current_Time"].split()
        if curr_time[0] == '12':
            curr_time_string = int(curr_time[1])
        else:
            curr_time_string = int(curr_time[0] + curr_time[1])

        response_emotion_arr.append(curr_time_string)
        request_emotion_arr.append(curr_time_string)

        request_emotion_writer.writerow(request_emotion_arr)
        response_emotion_writer.writerow(response_emotion_arr)

        if len(convo["response"]["intents"]) > 0:
            # print("im writing")
            intents = convo["response"]["intents"][0].values()
            input = convo["response"]["input"]["text"]
            output = convo["response"]["output"]["text"]

            if input is None:
                input = "Null"

            if len(output) == 0:
                output.append("Null")

            string = []
            for val in intents:
                string.append(val)

            string.append(input)
            string.append(output[0])

            csvwriter1.writerow(string)

    vogue_csv1.close()
    vogue_request_emotions.close()
    vogue_response_emotions.close()
