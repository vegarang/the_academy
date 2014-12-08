from django.views.generic import base


class HomePageView(base.TemplateView):
    template_name = "html2canvas_proto_ui/index.html"

    def get_context_data(self, **kwargs):
        return super(HomePageView, self).get_context_data(**kwargs)


class GalleryView(base.TemplateView):
    template_name = "html2canvas_proto_ui/gallery.html"

    def get_context_data(self, **kwargs):
        return super(GalleryView, self).get_context_data(**kwargs)