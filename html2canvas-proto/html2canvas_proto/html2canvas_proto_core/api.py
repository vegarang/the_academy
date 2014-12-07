from html2canvas_proto.html2canvas_proto_core import models
from rest_framework import serializers
from rest_framework import viewsets
from rest_framework import permissions
from rest_framework.response import Response
from rest_framework import status
from time import time
import os
import re
from django.core.files.base import ContentFile
from django.conf import settings


class CanvasTestSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.CanvasTest
        fields = (
            'image',
            'title',
            'url',
            'username',
            'description'
        )


class SimpleUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.SimpleUser
        fields = (
            'username',
        )


class CanvasTestViewSet(viewsets.ModelViewSet):
    queryset = models.CanvasTest.objects.all()
    serializer_class = CanvasTestSerializer
    permission_classes = [permissions.AllowAny]


class CanvasAsStringViewSet(viewsets.ViewSet):
    def create(self, request):
        dataUrlPattern = re.compile('data:image/(png|jpeg);base64,(.*)$')
        base64_string = dataUrlPattern.match(request.DATA['image']).group(2)

        filename = "uploaded_image{}.png".format(str(time()).replace('.', '_'))

        # decoding base string to image and saving in to your media root folder
        fh = open(os.path.join(settings.MEDIA_ROOT, 'tmp', filename), "wb")
        fh.write(str(base64_string.decode('base64')))
        fh.close()

        # saving decoded image to database
        decoded_image = base64_string.decode('base64')

        data = request.DATA
        data['image'] = ContentFile(decoded_image, filename)
        serializer = CanvasTestSerializer(data=data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class SimpleUserViewSet(viewsets.ModelViewSet):
    queryset = models.SimpleUser.objects.all()
    serializer_class = SimpleUserSerializer
    permission_classes = [permissions.AllowAny]