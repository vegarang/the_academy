from django.conf.urls import patterns, include, url
from rest_framework import routers
from html2canvas_proto.html2canvas_proto_core import api
from html2canvas_proto.html2canvas_proto_ui import views


router = routers.SimpleRouter(trailing_slash=False)
router.register(r'api/images', api.CanvasTestViewSet)
router.register(r'api/image_text', api.CanvasAsStringViewSet, base_name="image_text")
router.register(r'api/me', api.SimpleUserViewSet)

urlpatterns = [
    url(r'^', include(router.urls)),
    url(r'^$', views.HomePageView.as_view(), name='home'),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]
