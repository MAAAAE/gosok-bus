package com.gotor.gotor.service.stt

import com.google.cloud.speech.v1.RecognitionAudio
import com.google.cloud.speech.v1.RecognitionConfig
import com.google.cloud.speech.v1.SpeechClient
import com.google.cloud.speech.v1.SpeechRecognitionAlternative
import com.google.cloud.speech.v1.SpeechRecognitionResult
import com.google.protobuf.ByteString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SttApiClientServiceImpl(
    private val speechClient: SpeechClient
) : SttApiClientService {
    private val logger: Logger = LoggerFactory.getLogger(SttApiClientService::class.java)


    override fun toText(voice: MultipartFile): String {


        try {
            val audioBytes: ByteString = ByteString.copyFrom(voice.getBytes())

            val recognitionConfig: RecognitionConfig = RecognitionConfig.newBuilder()
                .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16) // 파일 포맷에 따라 변경
                .setSampleRateHertz(48000) // 오디오 샘플링 주파수
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
                logger.info("[Transcription] ${alternative.transcript}")
            }
            return results[0].alternativesList[0].transcript
        } catch (e: Exception) {
            logger.error("[speech to text] exception message: ${e.message}")
        }
        return "오류가 발생했습니다."
    }
}