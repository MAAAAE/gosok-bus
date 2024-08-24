package com.gotor.gotor.service.stt

import com.google.cloud.speech.v1.*
import com.google.protobuf.ByteString
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.reactive.function.client.WebClient

@Service
class SttApiClientServiceImpl(
    private val sttClient: WebClient,
    private val speechClient: SpeechClient,
): SttApiClientService {


    override fun toText(voice: MultipartFile): String {

        val audioBytes: ByteString = ByteString.copyFrom(voice.getBytes())

        val recognitionConfig: RecognitionConfig = RecognitionConfig.newBuilder()
            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16) // 파일 포맷에 따라 변경
            .setSampleRateHertz(16000) // 오디오 샘플링 주파수
            .setLanguageCode("ko-KR") // 언어 코드 설정
            .build()

        val recognitionAudio: RecognitionAudio = RecognitionAudio.newBuilder()
            .setContent(audioBytes)
            .build()

        // Performs speech recognition on the audio file

        // Performs speech recognition on the audio file
        val results: List<SpeechRecognitionResult> =
            speechClient.recognize(recognitionConfig, recognitionAudio).resultsList
        for (result in results) {
            // There can be several alternative transcripts for a given chunk of speech. Just use the
            // first (most likely) one here.
            val alternative: SpeechRecognitionAlternative = result.alternativesList[0]
            System.out.printf("Transcription: %s%n", alternative.transcript)
        }
        return results[0].toString()
    }
}